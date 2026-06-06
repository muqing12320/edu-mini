# clickhouse://node1:8123/edu_realtime
# db: edu_realtime
# table: dws_user_login_window
# table: dws_user_register_window

# drop table if exists dws_user_login_window;
# create table dws_user_login_window(
#     stt DateTime,
# edt DateTime,
# back_count UInt64,
# uv_count UInt64,
# ts UInt64
# ) engine = ReplacingMergeTree(ts)
# partition by toYYYYMMDD(stt)
# order by(stt, edt);
#
# drop table if exists dws_user_register_window;
# create table dws_user_register_window(
#     stt DateTime,
# edt DateTime,
# register_count UInt64,
# ts UInt64
# ) engine = ReplacingMergeTree(ts)
# partition by toYYYYMMDD(stt)
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ClickHouse 表创建脚本
创建 DWS 层聚合表：dws_user_login_window 和 dws_user_register_window
"""

import clickhouse_connect
import os
import sys


def get_clickhouse_client():
    """
    获取 ClickHouse 客户端连接
    """
    # ClickHouse 配置
    CLICKHOUSE_HOST = "node1"
    CLICKHOUSE_PORT = 8123
    CLICKHOUSE_DATABASE = "edu_realtime"
    CLICKHOUSE_USER = "default"  # 根据实际情况修改
    CLICKHOUSE_PASSWORD = ""      # 根据实际情况修改

    try:
        client = clickhouse_connect.get_client(
            host=CLICKHOUSE_HOST,
            port=CLICKHOUSE_PORT,
            username=CLICKHOUSE_USER,
            password=CLICKHOUSE_PASSWORD,
            database=CLICKHOUSE_DATABASE
        )
        print(f"✓ ClickHouse 客户端连接成功")
        print(f"  主机: {CLICKHOUSE_HOST}:{CLICKHOUSE_PORT}")
        print(f"  数据库: {CLICKHOUSE_DATABASE}")
        print("-" * 60)
        return client
    except Exception as e:
        print(f"✗ ClickHouse 客户端连接失败: {e}")
        import traceback
        traceback.print_exc()
        return None


def create_dws_user_login_window(client):
    """
    创建用户登录窗口聚合表
    """
    print("\n[1/2] 创建表: dws_user_login_window")
    print("-" * 60)

    # 删除已存在的表
    drop_sql = "DROP TABLE IF EXISTS dws_user_login_window"

    # 创建表的 SQL
    create_sql = """
                 CREATE TABLE dws_user_login_window (
                                                        stt DateTime COMMENT '窗口开始时间',
                                                        edt DateTime COMMENT '窗口结束时间',
                                                        back_count UInt64 COMMENT '回访用户数',
                                                        uv_count UInt64 COMMENT '独立访客数',
                                                        ts UInt64 COMMENT '时间戳'
                 ) ENGINE = ReplacingMergeTree(ts)
    PARTITION BY toYYYYMMDD(stt)
    ORDER BY (stt, edt) \
                 """

    try:
        # 执行 DROP TABLE
        client.command(drop_sql)
        print("  ✓ 已删除旧表（如果存在）")

        # 执行 CREATE TABLE
        client.command(create_sql)
        print("  ✓ 表创建成功")
        print("  表结构:")
        print("    - stt: DateTime (窗口开始时间)")
        print("    - edt: DateTime (窗口结束时间)")
        print("    - back_count: UInt64 (回访用户数)")
        print("    - uv_count: UInt64 (独立访客数)")
        print("    - ts: UInt64 (时间戳)")
        print("  引擎: ReplacingMergeTree(ts)")
        print("  分区: toYYYYMMDD(stt)")
        print("  排序: (stt, edt)")

        return True

    except Exception as e:
        print(f"  ✗ 创建表失败: {e}")
        import traceback
        traceback.print_exc()
        return False


def create_dws_user_register_window(client):
    """
    创建用户注册窗口聚合表
    """
    print("\n[2/2] 创建表: dws_user_register_window")
    print("-" * 60)

    # 删除已存在的表
    drop_sql = "DROP TABLE IF EXISTS dws_user_register_window"

    # 创建表的 SQL
    create_sql = """
                 CREATE TABLE dws_user_register_window (
                                                           stt DateTime COMMENT '窗口开始时间',
                                                           edt DateTime COMMENT '窗口结束时间',
                                                           register_count UInt64 COMMENT '注册用户数',
                                                           ts UInt64 COMMENT '时间戳'
                 ) ENGINE = ReplacingMergeTree(ts)
    PARTITION BY toYYYYMMDD(stt)
    ORDER BY (stt, edt) \
                 """

    try:
        # 执行 DROP TABLE
        client.command(drop_sql)
        print("  ✓ 已删除旧表（如果存在）")

        # 执行 CREATE TABLE
        client.command(create_sql)
        print("  ✓ 表创建成功")
        print("  表结构:")
        print("    - stt: DateTime (窗口开始时间)")
        print("    - edt: DateTime (窗口结束时间)")
        print("    - register_count: UInt64 (注册用户数)")
        print("    - ts: UInt64 (时间戳)")
        print("  引擎: ReplacingMergeTree(ts)")
        print("  分区: toYYYYMMDD(stt)")
        print("  排序: (stt, edt)")

        return True

    except Exception as e:
        print(f"  ✗ 创建表失败: {e}")
        import traceback
        traceback.print_exc()
        return False


def verify_tables(client):
    """
    验证表是否创建成功
    """
    print("\n" + "=" * 60)
    print("验证表创建结果")
    print("=" * 60)

    tables = ["dws_user_login_window", "dws_user_register_window"]

    for table_name in tables:
        try:
            result = client.command(f"EXISTS TABLE {table_name}")
            if result == 1 or result == '1':
                print(f"  ✓ {table_name} 存在")
            else:
                print(f"  ✗ {table_name} 不存在")
        except Exception as e:
            print(f"  ✗ 检查 {table_name} 失败: {e}")


def main():
    """
    主函数
    """
    print("=" * 60)
    print("ClickHouse DWS 层表创建工具")
    print("=" * 60)
    print()

    # 获取 ClickHouse 客户端
    client = get_clickhouse_client()
    if not client:
        print("\n✗ 无法连接到 ClickHouse，程序退出")
        sys.exit(1)

    try:
        # 创建用户登录窗口表
        success1 = create_dws_user_login_window(client)

        # 创建用户注册窗口表
        success2 = create_dws_user_register_window(client)

        # 验证表创建结果
        verify_tables(client)

        # 输出总结
        print("\n" + "=" * 60)
        print("创建完成!")
        print("=" * 60)
        if success1 and success2:
            print("  ✓ 所有表创建成功")
        else:
            print("  ⚠ 部分表创建失败，请检查错误信息")
            if not success1:
                print("    - dws_user_login_window: 失败")
            if not success2:
                print("    - dws_user_register_window: 失败")

    except Exception as e:
        print(f"\n✗ 执行过程中出错: {e}")
        import traceback
        traceback.print_exc()
    finally:
        # 关闭客户端连接
        client.close()
        print("\n✓ ClickHouse 客户端连接已关闭")


if __name__ == "__main__":
    main()
