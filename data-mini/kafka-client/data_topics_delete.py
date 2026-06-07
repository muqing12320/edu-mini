#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
删除 Kafka 中所有 topic 的脚本
"""

from kafka.admin import KafkaAdminClient
import sys


def delete_all_topics():
    """
    删除 Kafka 集群中的所有 topic
    """

    # Kafka 配置
    KAFKA_SERVER = "node1:9092,node2:9092,node3:9092"

    print("=" * 60)
    print("Kafka Topic 批量删除工具")
    print("=" * 60)
    print()

    try:
        # 创建 Admin Client
        print(f"正在连接 Kafka 服务器: {KAFKA_SERVER}")
        admin_client = KafkaAdminClient(
            bootstrap_servers=KAFKA_SERVER,
            client_id='topic_deleter'
        )
        print("✓ Kafka Admin Client 创建成功")
        print()

        # 获取所有 topic 列表
        print("正在获取所有 topic...")
        all_topics = admin_client.list_topics()

        if not all_topics:
            print("没有找到任何 topic")
            admin_client.close()
            return

        print(f"找到 {len(all_topics)} 个 topic:")
        for i, topic in enumerate(all_topics, 1):
            print(f"  {i}. {topic}")
        print()

        # 确认删除
        confirm = input(f"确定要删除这 {len(all_topics)} 个 topic 吗？(yes/no): ")
        if confirm.lower() != 'yes':
            print("操作已取消")
            admin_client.close()
            return

        print()
        print("开始删除 topic...")
        print("-" * 60)

        # 逐个删除 topic
        deleted_count = 0
        failed_count = 0

        for topic in all_topics:
            try:
                admin_client.delete_topics([topic])
                deleted_count += 1
                print(f"[{deleted_count}] ✓ 已删除: {topic}")
            except Exception as e:
                failed_count += 1
                print(f"[{failed_count}] ✗ 删除失败: {topic} - {e}")

        print("-" * 60)
        print()
        print("=" * 60)
        print(f"删除完成!")
        print(f"  ✓ 成功: {deleted_count} 个")
        print(f"  ✗ 失败: {failed_count} 个")
        print(f"  总计: {deleted_count + failed_count} 个")
        print("=" * 60)

        # 验证删除结果
        print()
        print("验证剩余 topic...")
        remaining_topics = admin_client.list_topics()
        if remaining_topics:
            print(f"警告: 仍有 {len(remaining_topics)} 个 topic 未被删除:")
            for topic in remaining_topics:
                print(f"  - {topic}")
        else:
            print("✓ 所有 topic 已成功删除")

        # 关闭连接
        admin_client.close()

    except Exception as e:
        print(f"✗ 错误: {e}")
        import traceback
        traceback.print_exc()


def delete_specific_topics(topics_to_delete):
    """
    删除指定的 topic 列表

    Args:
        topics_to_delete: 要删除的 topic 名称列表
    """

    # Kafka 配置
    KAFKA_SERVER = "node1:9092,node2:9092,node3:9092"

    print("=" * 60)
    print("Kafka Topic 指定删除工具")
    print("=" * 60)
    print()

    try:
        # 创建 Admin Client
        print(f"正在连接 Kafka 服务器: {KAFKA_SERVER}")
        admin_client = KafkaAdminClient(
            bootstrap_servers=KAFKA_SERVER,
            client_id='topic_deleter'
        )
        print("✓ Kafka Admin Client 创建成功")
        print()

        print(f"准备删除以下 {len(topics_to_delete)} 个 topic:")
        for i, topic in enumerate(topics_to_delete, 1):
            print(f"  {i}. {topic}")
        print()

        # 确认删除
        confirm = input(f"确定要删除这 {len(topics_to_delete)} 个 topic 吗？(yes/no): ")
        if confirm.lower() != 'yes':
            print("操作已取消")
            admin_client.close()
            return

        print()
        print("开始删除 topic...")
        print("-" * 60)

        # 删除指定的 topic
        deleted_count = 0
        failed_count = 0

        for topic in topics_to_delete:
            try:
                admin_client.delete_topics([topic])
                deleted_count += 1
                print(f"[{deleted_count}] ✓ 已删除: {topic}")
            except Exception as e:
                failed_count += 1
                print(f"[{failed_count}] ✗ 删除失败: {topic} - {e}")

        print("-" * 60)
        print()
        print("=" * 60)
        print(f"删除完成!")
        print(f"  ✓ 成功: {deleted_count} 个")
        print(f"  ✗ 失败: {failed_count} 个")
        print(f"  总计: {deleted_count + failed_count} 个")
        print("=" * 60)

        # 关闭连接
        admin_client.close()

    except Exception as e:
        print(f"✗ 错误: {e}")
        import traceback
        traceback.print_exc()


if __name__ == "__main__":
    # 检查命令行参数
    if len(sys.argv) > 1:
        # 如果提供了 topic 名称作为参数，则只删除这些 topic
        topics = sys.argv[1:]
        print(f"模式: 删除指定的 {len(topics)} 个 topic")
        print()
        delete_specific_topics(topics)
    else:
        # 默认删除所有 topic
        print("模式: 删除所有 topic")
        print()
        delete_all_topics()
