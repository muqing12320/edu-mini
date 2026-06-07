#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import paramiko
import pymysql
import json
import time
import os
import csv
from datetime import datetime

# ==================== 配置区域 ====================
# MySQL配置
MYSQL_CONFIG = {
    "host": "node1",
    "port": 3306,
    "user": "root",
    "password": "123456",
    "database": "edu"
}

# SSH配置（用于连接node1）
SSH_CONFIG = {
    "hostname": "node1",
    "port": 22,
    "username": "zhangsan",
    "password": "123456"
}

# 远程日志文件路径
REMOTE_LOG_FILE = "/opt/bigdata/mock/edu/log/app.log"

# 数据文件路径
CSV_USER_FILE = "user.csv"       # 用户信息CSV文件
JSON_LOG_FILE = "user.jsonl"    # 注册日志JSON文件（每行一个JSON）


# ==================== 1. 读取数据文件 ====================
def read_csv_users(csv_file):
    """从CSV文件读取用户信息列表"""
    users = []
    try:
        with open(csv_file, 'r', encoding='utf-8') as f:
            reader = csv.DictReader(f)
            for row in reader:
                users.append(row)
        print(f"✓ 从CSV读取到 {len(users)} 条用户信息")
    except FileNotFoundError:
        print(f"❌ CSV文件不存在: {csv_file}")
    except Exception as e:
        print(f"❌ 读取CSV文件失败: {e}")
    return users


def read_json_logs(json_file):
    """从JSONL文件读取注册日志模板列表（支持多行格式化的JSON对象拼接）"""
    logs = []
    try:
        with open(json_file, 'r', encoding='utf-8') as f:
            content = f.read()

        decoder = json.JSONDecoder()
        idx = 0
        # 跳过前导空白
        content = content.lstrip()
        while idx < len(content):
            # 从当前位置解析一个完整JSON对象
            obj, end_idx = decoder.raw_decode(content, idx)
            logs.append(obj)
            # 跳过已解析部分和中间的空白，继续解析下一个对象
            idx = end_idx
            while idx < len(content) and content[idx] in ' \t\n\r':
                idx += 1

        print(f"✓ 从JSON读取到 {len(logs)} 条日志模板")
    except FileNotFoundError:
        print(f"❌ JSON文件不存在: {json_file}")
    except json.JSONDecodeError as e:
        print(f"❌ JSON解析失败: {e}")
    except Exception as e:
        print(f"❌ 读取JSON文件失败: {e}")
    return logs

# ==================== 2. MySQL操作 ====================
def insert_user_and_get_id(user_info):
    """插入用户记录并返回自增ID"""
    connection = None
    try:
        connection = pymysql.connect(
            host=MYSQL_CONFIG["host"],
            port=MYSQL_CONFIG["port"],
            user=MYSQL_CONFIG["user"],
            password=MYSQL_CONFIG["password"],
            database=MYSQL_CONFIG["database"],
            charset="utf8mb4"
        )
        with connection.cursor() as cursor:
            insert_sql = """
                         INSERT INTO user_info
                         (login_name, nick_name, passwd, real_name, phone_num, email,
                          head_img, user_level, birthday, gender, create_time, operate_time, status)
                         VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) \
                         """
            now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            cursor.execute(insert_sql, (
                user_info["login_name"],
                user_info["nick_name"],
                user_info["passwd"],
                user_info["real_name"],
                user_info["phone_num"],
                user_info["email"],
                user_info["head_img"],
                user_info["user_level"],
                user_info["birthday"],
                user_info["gender"],
                now,   # create_time
                now,   # operate_time
                user_info["status"]
            ))
            connection.commit()
            user_id = cursor.lastrowid
            return user_id
    except pymysql.Error as e:
        print(f"❌ MySQL操作失败: {e}")
        return None
    finally:
        if connection:
            connection.close()


# ==================== 3. 构造JSON日志 ====================
def build_register_log(log_template, user_id):
    """根据日志模板和用户ID构造注册日志"""
    json_log = {
        "common": {
            "ar": log_template["common"]["ar"],
            "ba": log_template["common"]["ba"],
            "ch": log_template["common"]["ch"],
            "is_new": "1",
            "md": log_template["common"]["md"],
            "mid": log_template["common"]["mid"],
            "os": log_template["common"]["os"],
            "sc": log_template["common"]["sc"],
            "sid": log_template["common"]["sid"],
            "uid": str(user_id)   # 用数据库自增ID替换uid
        },
        "page": {
            "during_time": log_template["page"]["during_time"],
            "page_id": "register"
        },
        "ts": int(time.time() * 1000)
    }
    return json_log


# ==================== 4. 通过SSH追加日志到远程文件 ====================
def append_log_remote(log_line):
    """通过SSH连接到远程服务器并追加日志到文件"""
    ssh_client = None
    try:
        ssh_client = paramiko.SSHClient()
        ssh_client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh_client.connect(
            hostname=SSH_CONFIG["hostname"],
            port=SSH_CONFIG["port"],
            username=SSH_CONFIG["username"],
            password=SSH_CONFIG["password"]
        )

        # 确保目录存在
        remote_dir = os.path.dirname(REMOTE_LOG_FILE)
        mkdir_cmd = f"mkdir -p {remote_dir}"
        ssh_client.exec_command(mkdir_cmd)

        # 追加日志
        escaped_log = log_line.replace("'", "'\\''")
        append_cmd = f"echo '{escaped_log}' >> {REMOTE_LOG_FILE}"

        stdin, stdout, stderr = ssh_client.exec_command(append_cmd)
        stdout.channel.recv_exit_status()

        error = stderr.read().decode().strip()
        if error and "No such file" not in error:
            print(f"⚠️ SSH命令警告: {error}")

        return True
    except paramiko.AuthenticationException:
        print("❌ SSH认证失败，请检查用户名和密码")
        return False
    except paramiko.SSHException as e:
        print(f"❌ SSH连接错误: {e}")
        return False
    except Exception as e:
        print(f"❌ 未知错误: {e}")
        return False
    finally:
        if ssh_client:
            ssh_client.close()


# ==================== 主流程 ====================
def main():
    print("========== 模拟用户注册 ==========")
    print()

    # 1. 读取数据文件
    csv_users = read_csv_users(CSV_USER_FILE)
    json_logs = read_json_logs(JSON_LOG_FILE)

    if not csv_users:
        print("❌ 没有可用的用户数据！")
        exit(1)

    if not json_logs:
        print("❌ 没有可用的日志模板！")
        exit(1)

    # 取两者最小长度，确保一一对应
    count = min(len(csv_users), len(json_logs))
    print(f"✓ 将处理 {count} 个用户的注册")
    print()

    success_count = 0
    fail_count = 0

    for i in range(count):
        user_info = csv_users[i]
        log_template = json_logs[i]

        print(f"--- 处理第 {i+1} 个用户: {user_info['login_name']} ---")

        # 2. 插入MySQL并获取自增ID
        user_id = insert_user_and_get_id(user_info)
        if user_id is None or user_id == 0:
            print(f"  ❌ 插入MySQL失败，跳过")
            fail_count += 1
            continue

        print(f"  ✓ 已插入MySQL，用户ID: {user_id}")

        # 3. 构造JSON日志
        json_log = build_register_log(log_template, user_id)
        json_log_str = json.dumps(json_log, separators=(',', ':'), ensure_ascii=False)
        print(f"  ✓ 生成日志: {json_log_str[:80]}...")

        # 4. 追加日志到远程文件
        if append_log_remote(json_log_str):
            print(f"  ✓ 日志已追加到远程文件")
            success_count += 1
        else:
            print(f"  ❌ 写入远程日志失败")
            fail_count += 1

        print()

    # 汇总
    print("========== 完成 ==========")
    print(f"成功: {success_count}  失败: {fail_count}  总计: {count}")
    print()
    print("后续流程：")
    print("  Maxwell 会捕获 MySQL binlog → topic_db")
    print("  Flume  会读取 app.log → dwd_traffic_page_log")
    print("  Flink  程序会 JOIN 两张表")


if __name__ == "__main__":
    main()