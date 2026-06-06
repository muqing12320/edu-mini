# db: edu_realtime
# table: dws_user_login_window
# table: dws_user_register_window

#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ClickHouse 表创建脚本
创建 DWS 层聚合表：dws_user_login_window 和 dws_user_register_window
"""
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ClickHouse 表数据清空脚本
清空 DWS 层聚合表数据：dws_user_login_window 和 dws_user_register_window
"""

import clickhouse_connect
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


def truncate_table(client, table_name):
    """
    清空指定表的数据

    Args:
        client: ClickHouse 客户端
        table_name: 表名

    Returns:
        bool: 是否成功
    """
    print(f"\n清空表: {table_name}")
    print("-" * 60)

    # 查询清空前的数据量
    try:
        count_before = client.command(f"SELECT COUNT(*) FROM {table_name}")
        print(f"  清空前数据量: {count_before} 条")
    except Exception as e:
        print(f"  ⚠ 查询数据量失败: {e}")

    # 执行 TRUNCATE TABLE
    truncate_sql = f"TRUNCATE TABLE {table_name}"

    try:
        client.command(truncate_sql)
        print(f"  ✓ 表 {table_name} 已清空")

        # 验证清空结果
        count_after = client.command(f"SELECT COUNT(*) FROM {table_name}")
        print(f"  清空后数据量: {count_after} 条")

        if count_after == 0 or count_after == '0':
            print(f"  ✓ 验证通过：表已完全清空")
            return True
        else:
            print(f"  ⚠ 警告：表中仍有 {count_after} 条数据")
            return False

    except Exception as e:
        print(f"  ✗ 清空表 {table_name} 失败: {e}")
        import traceback
        traceback.print_exc()
        return False


def check_table_exists(client, table_name):
    """
    检查表是否存在

    Args:
        client: ClickHouse 客户端
        table_name: 表名

    Returns:
        bool: 表是否存在
    """
    try:
        result = client.command(f"EXISTS TABLE {table_name}")
        return result == 1 or result == '1'
    except Exception:
        return False


def main():
    """
    主函数
    """
    print("=" * 60)
    print("ClickHouse DWS 层表数据清空工具")
    print("=" * 60)
    print()

    # 要清空的表列表
    tables = [
        "dws_user_login_window",
        "dws_user_register_window"
    ]

    # 获取 ClickHouse 客户端
    client = get_clickhouse_client()
    if not client:
        print("\n✗ 无法连接到 ClickHouse，程序退出")
        sys.exit(1)

    try:
        success_count = 0
        failed_count = 0
        skipped_count = 0

        # 依次清空每个表
        for idx, table_name in enumerate(tables, 1):
            print(f"\n[{idx}/{len(tables)}] 处理表: {table_name}")

            # 检查表是否存在
            if not check_table_exists(client, table_name):
                print(f"  ⚠ 表 {table_name} 不存在，跳过")
                skipped_count += 1
                continue

            # 清空表
            if truncate_table(client, table_name):
                success_count += 1
            else:
                failed_count += 1

        # 输出总结
        print("\n" + "=" * 60)
        print("清空完成!")
        print("=" * 60)
        print(f"  ✓ 成功: {success_count} 个表")
        if failed_count > 0:
            print(f"  ✗ 失败: {failed_count} 个表")
        if skipped_count > 0:
            print(f"  ⚠ 跳过: {skipped_count} 个表（表不存在）")
        print(f"  总计: {len(tables)} 个表")

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
