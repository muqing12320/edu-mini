# db: edu_realtime
# table: dws_user_login_window
# table: dws_user_register_window
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ClickHouse 表数据查询脚本
查询 DWS 层聚合表数据：dws_user_login_window 和 dws_user_register_window
"""

import clickhouse_connect
from tabulate import tabulate
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


def query_table_data(client, table_name, limit=100):
    """
    查询指定表的数据

    Args:
        client: ClickHouse 客户端
        table_name: 表名
        limit: 限制返回的记录数，默认100条

    Returns:
        bool: 是否成功
    """
    print(f"\n查询表: {table_name}")
    print("=" * 60)

    # 查询总记录数
    try:
        total_count = client.command(f"SELECT COUNT(*) FROM {table_name}")
        print(f"总记录数: {total_count} 条")
        print(f"显示前 {min(limit, int(total_count))} 条记录")
        print("-" * 60)
    except Exception as e:
        print(f"⚠ 查询总记录数失败: {e}")

    # 查询数据
    query_sql = f"SELECT * FROM {table_name} ORDER BY stt DESC LIMIT {limit}"

    try:
        result = client.query(query_sql)

        if not result.result_rows:
            print("  ⚠ 表中没有数据")
            return True

        # 获取列名
        column_names = [col[0] for col in result.column_names]

        # 格式化输出数据
        table_data = []
        for row in result.result_rows:
            table_data.append(row)

        # 使用 tabulate 美化输出
        print(tabulate(table_data, headers=column_names, tablefmt='grid'))

        print(f"\n✓ 成功查询 {len(table_data)} 条记录")
        return True

    except Exception as e:
        print(f"✗ 查询表 {table_name} 失败: {e}")
        import traceback
        traceback.print_exc()
        return False


def query_table_summary(client, table_name):
    """
    查询表的统计信息

    Args:
        client: ClickHouse 客户端
        table_name: 表名

    Returns:
        bool: 是否成功
    """
    print(f"\n表统计信息: {table_name}")
    print("=" * 60)

    try:
        # 查询总记录数
        count_result = client.command(f"SELECT COUNT(*) FROM {table_name}")
        print(f"  总记录数: {count_result}")

        # 根据表类型查询不同的统计信息
        if table_name == "dws_user_login_window":
            # 登录窗口表统计
            stats_sql = """
                        SELECT
                            MIN(stt) as earliest_start,
                            MAX(edt) as latest_end,
                            SUM(back_count) as total_back_count,
                            SUM(uv_count) as total_uv_count,
                            AVG(back_count) as avg_back_count,
                            AVG(uv_count) as avg_uv_count
                        FROM dws_user_login_window \
                        """
        elif table_name == "dws_user_register_window":
            # 注册窗口表统计
            stats_sql = """
                        SELECT
                            MIN(stt) as earliest_start,
                            MAX(edt) as latest_end,
                            SUM(register_count) as total_register_count,
                            AVG(register_count) as avg_register_count
                        FROM dws_user_register_window \
                        """
        else:
            print("  ⚠ 未知的表类型，跳过详细统计")
            return True

        stats_result = client.query(stats_sql)
        if stats_result.result_rows:
            row = stats_result.result_rows[0]
            columns = [col[0] for col in stats_result.column_names]

            print("\n  统计详情:")
            for col_name, value in zip(columns, row):
                print(f"    {col_name}: {value}")

        return True

    except Exception as e:
        print(f"✗ 查询统计信息失败: {e}")
        import traceback
        traceback.print_exc()
        return False


def list_all_tables(client):
    """
    列出数据库中的所有表

    Args:
        client: ClickHouse 客户端
    """
    print("\n数据库中的所有表:")
    print("=" * 60)

    try:
        result = client.query("SHOW TABLES")
        tables = [row[0] for row in result.result_rows]

        for idx, table in enumerate(tables, 1):
            print(f"  {idx}. {table}")

        print(f"\n共 {len(tables)} 个表")
        return tables

    except Exception as e:
        print(f"✗ 查询表列表失败: {e}")
        return []


def main():
    """
    主函数
    """
    print("=" * 60)
    print("ClickHouse DWS 层表数据查询工具")
    print("=" * 60)
    print()

    # 要查询的表列表
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
        # 选择查询模式
        print("请选择查询模式:")
        print("  1. 查询所有表的数据")
        print("  2. 查询所有表的统计信息")
        print("  3. 列出所有表")
        print("  4. 自定义查询")

        choice = input("\n请输入选项 (1-4，默认1): ").strip() or "1"

        if choice == "1":
            # 查询所有表的数据
            limit_input = input("请输入每表查询记录数 (默认100): ").strip()
            limit = int(limit_input) if limit_input.isdigit() else 100

            success_count = 0
            for idx, table_name in enumerate(tables, 1):
                print(f"\n[{idx}/{len(tables)}] 处理表: {table_name}")
                if query_table_data(client, table_name, limit):
                    success_count += 1

            print("\n" + "=" * 60)
            print(f"查询完成! 成功: {success_count}/{len(tables)}")

        elif choice == "2":
            # 查询所有表的统计信息
            success_count = 0
            for idx, table_name in enumerate(tables, 1):
                print(f"\n[{idx}/{len(tables)}] 处理表: {table_name}")
                if query_table_summary(client, table_name):
                    success_count += 1

            print("\n" + "=" * 60)
            print(f"统计查询完成! 成功: {success_count}/{len(tables)}")

        elif choice == "3":
            # 列出所有表
            list_all_tables(client)

        elif choice == "4":
            # 自定义查询
            print("\n可用的表:")
            for idx, table in enumerate(tables, 1):
                print(f"  {idx}. {table}")

            table_choice = input("\n请选择表 (输入序号或表名): ").strip()

            if table_choice.isdigit():
                idx = int(table_choice) - 1
                if 0 <= idx < len(tables):
                    selected_table = tables[idx]
                else:
                    print("无效的选项")
                    return
            else:
                selected_table = table_choice

            print(f"\n对表 '{selected_table}' 执行自定义 SQL 查询")
            print("提示: 输入 'quit' 退出，输入 'help' 查看示例")

            while True:
                sql = input("\nSQL> ").strip()

                if sql.lower() == 'quit':
                    break
                elif sql.lower() == 'help':
                    print("\n示例查询:")
                    print(f"  SELECT * FROM {selected_table} LIMIT 10")
                    print(f"  SELECT COUNT(*) FROM {selected_table}")
                    print(f"  SELECT stt, edt FROM {selected_table} WHERE stt > '2026-01-01'")
                    continue
                elif not sql:
                    continue

                try:
                    result = client.query(sql)

                    if result.result_rows:
                        column_names = [col[0] for col in result.column_names]
                        table_data = [row for row in result.result_rows]
                        print(tabulate(table_data, headers=column_names, tablefmt='grid'))
                        print(f"\n✓ 返回 {len(table_data)} 条记录")
                    else:
                        print("✓ 查询执行成功，无返回结果")

                except Exception as e:
                    print(f"✗ 查询失败: {e}")

        else:
            print("无效的选项")

    except KeyboardInterrupt:
        print("\n\n用户中断执行")
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
