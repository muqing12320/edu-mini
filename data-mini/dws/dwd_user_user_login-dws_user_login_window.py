#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
从 dwd_user_user_login.jsonl 文件读取数据并发送到 Kafka 的 dwd_user_user_login topic
"""

import json
from kafka import KafkaProducer
import time
import os


def send_jsonl_to_kafka():
    """
    读取 JSONL 文件并发送到 Kafka
    """

    # Kafka 配置
    KAFKA_SERVER = "node1:9092,node2:9092,node3:9092"
    TOPIC_NAME = "dwd_user_user_login"

    # JSONL 文件路径
    script_dir = os.path.dirname(os.path.abspath(__file__))
    jsonl_file = os.path.join(script_dir, "dwd_user_user_login.jsonl")

    print("=" * 60)
    print("Kafka 测试数据发送工具 - DWD User Login")
    print("=" * 60)
    print()
    print(f"正在读取文件: {jsonl_file}")

    # 检查文件是否存在
    if not os.path.exists(jsonl_file):
        print(f"✗ 错误: 文件不存在 - {jsonl_file}")
        return

    # 创建 Kafka Producer
    try:
        producer = KafkaProducer(
            bootstrap_servers=KAFKA_SERVER,
            value_serializer=lambda v: v.encode('utf-8') if isinstance(v, str) else json.dumps(v, ensure_ascii=False).encode('utf-8'),
            acks='all',  # 等待所有副本确认
            retries=3,   # 重试次数
            max_block_ms=60000  # 最大阻塞时间
        )
        print(f"✓ Kafka Producer 创建成功")
        print(f"✓ 目标 Topic: {TOPIC_NAME}")
        print(f"✓ Kafka 服务器: {KAFKA_SERVER}")
        print("-" * 60)
        print()

    except Exception as e:
        print(f"✗ Kafka Producer 创建失败: {e}")
        import traceback
        traceback.print_exc()
        return

    # 读取并发送数据
    sent_count = 0
    failed_count = 0

    try:
        with open(jsonl_file, 'r', encoding='utf-8') as f:
            content = f.read().strip()

            # 尝试解析为 JSON 数组
            try:
                data_list = json.loads(content)

                # 如果是单个对象，转换为列表
                if isinstance(data_list, dict):
                    data_list = [data_list]

                print(f"找到 {len(data_list)} 条数据")
                print()

            except json.JSONDecodeError:
                # 如果不是标准 JSON 数组，按行读取（JSONL 格式）
                data_list = []
                for line in content.split('\n'):
                    line = line.strip()
                    if line:
                        try:
                            data_list.append(json.loads(line))
                        except json.JSONDecodeError as e:
                            print(f"⚠ 跳过无效 JSON 行: {e}")

                print(f"找到 {len(data_list)} 条数据")
                print()

            # 发送每条数据
            for idx, data in enumerate(data_list, 1):
                try:
                    # 将数据转换为 JSON 字符串
                    json_str = json.dumps(data, ensure_ascii=False)

                    # 发送消息到 Kafka
                    future = producer.send(TOPIC_NAME, value=json_str)

                    # 等待发送结果
                    record_metadata = future.get(timeout=10)

                    sent_count += 1

                    # 提取关键信息用于展示
                    user_id = data.get('userId', 'N/A')
                    login_time = data.get('loginTime', 'N/A')
                    ts = data.get('ts', 0)

                    print(f"[{sent_count}] ✓ 已发送:")
                    print(f"    User ID: {user_id}")
                    print(f"    Login Time: {login_time}")
                    print(f"    Timestamp: {ts}")
                    print(f"    Partition: {record_metadata.partition}, Offset: {record_metadata.offset}")
                    print()

                    # 可选：添加延迟，模拟真实场景
                    # time.sleep(0.5)

                except Exception as e:
                    failed_count += 1
                    print(f"[{idx}] ✗ 发送失败: {e}")
                    import traceback
                    traceback.print_exc()
                    print()

        # 确保所有消息都已发送
        producer.flush()

        print("=" * 60)
        print(f"发送完成!")
        print(f"  ✓ 成功: {sent_count} 条")
        print(f"  ✗ 失败: {failed_count} 条")
        print(f"  总计: {sent_count + failed_count} 条")
        print("=" * 60)

    except FileNotFoundError:
        print(f"✗ 文件未找到: {jsonl_file}")
    except Exception as e:
        print(f"✗ 处理文件时出错: {e}")
        import traceback
        traceback.print_exc()
    finally:
        # 关闭 Producer
        producer.close()
        print()
        print("✓ Kafka Producer 已关闭")


if __name__ == "__main__":
    send_jsonl_to_kafka()
