-- 只保留建表语句

-- 源文件：edu0222_mini.sql

-- 共提取 25 个表结构

CREATE TABLE `base_category_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_name` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='分类 分类';

CREATE TABLE `base_province` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '省名称',
  `region_id` varchar(20) DEFAULT NULL COMMENT '大区id',
  `area_code` varchar(20) DEFAULT NULL COMMENT '行政区位码',
  `iso_code` varchar(20) DEFAULT NULL COMMENT '国际编码',
  `iso_3166_2` varchar(20) DEFAULT NULL COMMENT 'ISO3166编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_source` (
  `id` bigint(20) NOT NULL,
  `source_site` varchar(20) DEFAULT NULL,
  `source_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `base_subject_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `subject_name` varchar(200) DEFAULT NULL COMMENT '科目名称',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学科 学科';

CREATE TABLE `cart_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `course_name` varchar(200) DEFAULT NULL COMMENT 'sku名称 (冗余)',
  `cart_price` decimal(10,2) DEFAULT NULL COMMENT '放入购物车时价格',
  `img_url` varchar(200) DEFAULT NULL COMMENT '图片文件',
  `session_id` varchar(200) DEFAULT NULL COMMENT '会话id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` varchar(2) DEFAULT NULL,
  `sold` varchar(2) DEFAULT NULL COMMENT '是否已售',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4745 DEFAULT CHARSET=utf8 COMMENT='购物车表 用户登录系统时更新冗余';

CREATE TABLE `chapter_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `chapter_name` varchar(200) DEFAULT NULL COMMENT '章节名称',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `video_id` bigint(20) DEFAULT NULL COMMENT '视频id',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `is_free` varchar(2) DEFAULT NULL COMMENT '是否免费',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_cid` (`course_id`),
  KEY `idx_vid` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26306 DEFAULT CHARSET=utf8 COMMENT='章节 章节';

CREATE TABLE `comment_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户名称',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `comment_txt` varchar(2000) DEFAULT NULL COMMENT '评价内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` varchar(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1632 DEFAULT CHARSET=utf8 COMMENT='评论表';

CREATE TABLE `course_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_name` varchar(200) DEFAULT NULL COMMENT '课程名称',
  `course_slogan` varchar(200) DEFAULT NULL COMMENT '课程标语',
  `course_cover_url` varchar(200) DEFAULT NULL COMMENT '课程封面',
  `subject_id` bigint(20) DEFAULT NULL COMMENT '学科id',
  `teacher` varchar(4000) DEFAULT NULL COMMENT '讲师名称',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `chapter_num` bigint(20) DEFAULT NULL COMMENT '章节数',
  `origin_price` decimal(16,2) DEFAULT NULL COMMENT '价格',
  `reduce_amount` decimal(16,2) DEFAULT NULL COMMENT '优惠金额',
  `actual_price` decimal(16,2) DEFAULT NULL COMMENT '实际价格',
  `course_introduce` varchar(2000) DEFAULT NULL COMMENT '课程介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=453 DEFAULT CHARSET=utf8 COMMENT='课程 课程';

CREATE TABLE `favor_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7294 DEFAULT CHARSET=utf8 COMMENT='收藏 收藏';

CREATE TABLE `knowledge_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `point_txt` varchar(4000) DEFAULT NULL COMMENT '知识点 内容  ',
  `point_level` bigint(20) DEFAULT NULL COMMENT '知识点基本',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='知识点 知识点';

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `course_name` varchar(4000) DEFAULT NULL COMMENT '课程名称',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `origin_amount` decimal(16,2) DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(16,2) DEFAULT NULL COMMENT '优惠劵减免金额',
  `final_amount` decimal(16,2) DEFAULT NULL COMMENT '最终金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_oid_cid` (`order_id`,`course_id`),
  KEY `idx_cid` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17384 DEFAULT CHARSET=utf8 COMMENT='订单明细 订单明细';

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `origin_amount` decimal(10,2) DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(10,2) DEFAULT NULL COMMENT '优惠券减免',
  `final_amount` decimal(10,2) DEFAULT NULL COMMENT '最终金额',
  `order_status` varchar(20) DEFAULT NULL COMMENT '订单状态',
  `out_trade_no` varchar(50) DEFAULT NULL COMMENT '订单交易编号（第三方支付用)',
  `trade_body` varchar(200) DEFAULT NULL COMMENT '订单描述(第三方支付用)',
  `session_id` varchar(100) DEFAULT NULL COMMENT 'session id',
  `province_id` bigint(20) DEFAULT NULL COMMENT '地区id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `expire_time` datetime DEFAULT NULL COMMENT '失效时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16824 DEFAULT CHARSET=utf8 COMMENT='订单表 订单表';

CREATE TABLE `payment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `alipay_trade_no` varchar(50) DEFAULT NULL COMMENT '支付宝交易编号',
  `total_amount` decimal(10,0) DEFAULT NULL COMMENT '支付金额',
  `trade_body` varchar(200) DEFAULT NULL COMMENT '交易内容',
  `payment_type` varchar(20) DEFAULT NULL,
  `payment_status` varchar(20) DEFAULT NULL COMMENT '支付状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `callback_content` varchar(1000) DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime DEFAULT NULL COMMENT '回调时间',
  PRIMARY KEY (`id`),
  KEY `idx_oid` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9315 DEFAULT CHARSET=utf8 COMMENT='支付信息表';

CREATE TABLE `review_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户名称',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `review_txt` varchar(4000) DEFAULT NULL COMMENT '评价内容',
  `review_stars` bigint(20) DEFAULT NULL COMMENT '评价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` varchar(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uid` (`user_id`,`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1634 DEFAULT CHARSET=utf8 COMMENT='评价表';

CREATE TABLE `test_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `paper_id` bigint(20) DEFAULT NULL COMMENT '考卷id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `score` decimal(10,2) DEFAULT NULL COMMENT '分数',
  `duration_sec` bigint(20) DEFAULT NULL COMMENT '所用时长',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1540 DEFAULT CHARSET=utf8 COMMENT='做卷记录 做卷记录';

CREATE TABLE `test_exam_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `exam_id` bigint(20) DEFAULT NULL COMMENT '考试id',
  `paper_id` bigint(20) DEFAULT NULL COMMENT '试卷id',
  `question_id` bigint(20) DEFAULT NULL COMMENT '问题id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `answer` varchar(2000) DEFAULT NULL COMMENT '答案',
  `is_correct` varchar(2) DEFAULT NULL COMMENT '是否正确',
  `score` decimal(16,2) DEFAULT NULL COMMENT '本题得分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_eid` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22705 DEFAULT CHARSET=utf8 COMMENT='做卷记录 做卷记录';

CREATE TABLE `test_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `paper_title` varchar(200) DEFAULT NULL COMMENT '试卷名称',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_cid` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='试卷 试卷';

CREATE TABLE `test_paper_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `paper_id` bigint(20) DEFAULT NULL COMMENT '试卷id',
  `question_id` bigint(20) DEFAULT NULL COMMENT '题目id',
  `score` decimal(10,2) DEFAULT NULL COMMENT '得分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_pid` (`paper_id`,`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3225 DEFAULT CHARSET=utf8 COMMENT='试卷问题关联表 试卷问题关联表';

CREATE TABLE `test_point_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `point_id` bigint(20) DEFAULT NULL COMMENT '知识点 内容  ',
  `question_id` bigint(20) DEFAULT NULL COMMENT '知识点基本',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='知识点与问题的关联 知识点与问题的关联';

CREATE TABLE `test_question_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `question_txt` varchar(4000) DEFAULT NULL COMMENT '题目内容',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `course_id` bigint(20) DEFAULT NULL COMMENT '视频id',
  `question_type` bigint(20) DEFAULT NULL COMMENT '题目类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_chid` (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2609 DEFAULT CHARSET=utf8 COMMENT='题目 题目';

CREATE TABLE `test_question_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `option_txt` varchar(2000) DEFAULT NULL COMMENT '选项内容',
  `question_id` bigint(20) DEFAULT NULL COMMENT '题目id',
  `is_correct` varchar(2) DEFAULT NULL COMMENT '是否正确',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_qid` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9118 DEFAULT CHARSET=utf8 COMMENT='题目选项 题目选项';

CREATE TABLE `user_chapter_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `position_sec` bigint(20) DEFAULT NULL COMMENT '时长位置',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1691 DEFAULT CHARSET=utf8 COMMENT='用户章节观看进度 用户章节观看进度';

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '用户昵称',
  `passwd` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `phone_num` varchar(200) DEFAULT NULL COMMENT '手机号',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `head_img` varchar(200) DEFAULT NULL COMMENT '头像',
  `user_level` varchar(200) DEFAULT NULL COMMENT '用户级别',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别 M男,F女',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

CREATE TABLE `video_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `video_name` varchar(200) DEFAULT NULL COMMENT '视频名称',
  `during_sec` bigint(20) DEFAULT NULL COMMENT '时长',
  `video_status` varchar(4000) DEFAULT NULL COMMENT '状态 未上传，上传中，上传完',
  `video_size` bigint(20) DEFAULT NULL COMMENT '大小',
  `video_url` varchar(500) DEFAULT NULL COMMENT '视频存储路径',
  `video_source_id` varchar(200) DEFAULT NULL COMMENT '云端资源编号',
  `version_id` bigint(20) DEFAULT NULL COMMENT '版本号',
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `publisher_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` varchar(2) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `idx_chid` (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5411 DEFAULT CHARSET=utf8 COMMENT='视频 视频';

CREATE TABLE `vip_change_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `from_vip` bigint(20) DEFAULT NULL COMMENT 'vip(从）',
  `to_vip` bigint(20) DEFAULT NULL COMMENT 'vip(到）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9248 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ============================================
-- 示例数据插入语句
-- 源文件：edu0222_mini_create_only.sql
-- 生成时间：2026-03-06 10:14:43
-- 共 14 个表，每个表 3 条数据，共 42 条插入语句
-- ============================================

-- ============================================
-- 表：base_category_info (3 条数据)
-- ============================================
INSERT INTO `base_category_info` (`id`, `category_name`, `create_time`, `update_time`, `deleted`) VALUES (1, '编程开发', '2023-06-26 23:51:10', '2023-07-11 23:51:10', 'N');
INSERT INTO `base_category_info` (`id`, `category_name`, `create_time`, `update_time`, `deleted`) VALUES (2, '数据分析', '2021-03-27 21:58:45', '2021-04-02 21:58:45', 'N');
INSERT INTO `base_category_info` (`id`, `category_name`, `create_time`, `update_time`, `deleted`) VALUES (3, '产品设计', '2020-06-16 03:46:28', '2020-06-25 03:46:28', 'N');

-- ============================================
-- 表：base_province (3 条数据)
-- ============================================
INSERT INTO `base_province` (`id`, `name`, `region_id`, `area_code`, `iso_code`, `iso_3166_2`) VALUES (1, '北京市', '110000', '110000', 'CN', 'CN-BJ');
INSERT INTO `base_province` (`id`, `name`, `region_id`, `area_code`, `iso_code`, `iso_3166_2`) VALUES (2, '上海市', '310000', '310000', 'CN', 'CN-SH');
INSERT INTO `base_province` (`id`, `name`, `region_id`, `area_code`, `iso_code`, `iso_3166_2`) VALUES (3, '广东省', '440000', '440000', 'CN', 'CN-GD');

-- ============================================
-- 表：base_source (3 条数据)
-- ============================================
INSERT INTO `base_source` (`id`, `source_site`, `source_url`) VALUES (1, 'official', 'https://www.example.com');
INSERT INTO `base_source` (`id`, `source_site`, `source_url`) VALUES (2, 'partner', 'https://partner.example.com');
INSERT INTO `base_source` (`id`, `source_site`, `source_url`) VALUES (3, 'third_party', 'https://third.example.com');

-- ============================================
-- 表：base_subject_info (3 条数据)
-- ============================================
INSERT INTO `base_subject_info` (`id`, `subject_name`, `category_id`, `create_time`, `update_time`, `deleted`) VALUES (1, 'Java 全栈开发', 1, '2025-05-21 00:30:11', '2025-05-27 00:30:11', 'N');
INSERT INTO `base_subject_info` (`id`, `subject_name`, `category_id`, `create_time`, `update_time`, `deleted`) VALUES (2, 'Python 数据分析', 1, '2025-08-17 23:22:55', '2025-08-26 23:22:55', 'N');
INSERT INTO `base_subject_info` (`id`, `subject_name`, `category_id`, `create_time`, `update_time`, `deleted`) VALUES (3, 'UI/UX 设计', 3, '2022-05-14 22:43:18', '2022-06-08 22:43:18', 'N');

-- ============================================
-- 表：chapter_info (3 条数据)
-- ============================================
INSERT INTO `chapter_info` (`id`, `chapter_name`, `course_id`, `video_id`, `publisher_id`, `is_free`, `create_time`, `deleted`, `update_time`) VALUES (1, '第一章：Java 基础', 1, 1, 1, 'N', '2024-06-29 10:36:47', 'N', '2024-07-08 10:36:47');
INSERT INTO `chapter_info` (`id`, `chapter_name`, `course_id`, `video_id`, `publisher_id`, `is_free`, `create_time`, `deleted`, `update_time`) VALUES (2, '第二章：面向对象编程', 1, 2, 1, 'N', '2020-09-09 02:38:51', 'N', '2020-09-30 02:38:51');
INSERT INTO `chapter_info` (`id`, `chapter_name`, `course_id`, `video_id`, `publisher_id`, `is_free`, `create_time`, `deleted`, `update_time`) VALUES (3, '第三章：集合框架', 1, 3, 1, 'Y', '2025-03-26 07:56:50', 'N', '2025-04-22 07:56:50');

-- ============================================
-- 表：course_info (3 条数据)
-- ============================================
INSERT INTO `course_info` (`id`, `course_name`, `course_slogan`, `course_cover_url`, `subject_id`, `teacher`, `publisher_id`, `chapter_num`, `origin_price`, `reduce_amount`, `actual_price`, `course_introduce`, `create_time`, `deleted`, `update_time`) VALUES (1, 'Java 全栈开发工程师', '从入门到精通，成为全栈开发者', 'https://img.example.com/java.jpg', 1, '张三老师', 1, 20, 1999.0, 500.0, 1499.0, '本课程涵盖 Java 开发所需的全部技能', '2021-02-07 12:13:48', 'N', '2021-02-15 12:13:48');
INSERT INTO `course_info` (`id`, `course_name`, `course_slogan`, `course_cover_url`, `subject_id`, `teacher`, `publisher_id`, `chapter_num`, `origin_price`, `reduce_amount`, `actual_price`, `course_introduce`, `create_time`, `deleted`, `update_time`) VALUES (2, 'Python 数据分析实战', '掌握 Python 数据分析核心技能', 'https://img.example.com/python.jpg', 2, '李四老师', 1, 15, 1599.0, 300.0, 1299.0, '实战驱动，快速提升数据分析能力', '2023-06-04 11:16:35', 'N', '2023-06-06 11:16:35');
INSERT INTO `course_info` (`id`, `course_name`, `course_slogan`, `course_cover_url`, `subject_id`, `teacher`, `publisher_id`, `chapter_num`, `origin_price`, `reduce_amount`, `actual_price`, `course_introduce`, `create_time`, `deleted`, `update_time`) VALUES (3, 'UI/UX 设计从入门到就业', '系统学习 UI/UX 设计全流程', 'https://img.example.com/ui.jpg', 3, '王五老师', 1, 18, 2499.0, 600.0, 1899.0, '培养专业设计师的完整课程', '2021-03-15 19:33:48', 'N', '2021-04-09 19:33:48');

-- ============================================
-- 表：knowledge_point (3 条数据)
-- ============================================
INSERT INTO `knowledge_point` (`id`, `point_txt`, `point_level`, `course_id`, `chapter_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (1, 'Java 是一种面向对象的编程语言，具有简单、高效、跨平台等特性', 1, 1, 1, '2023-07-21 22:13:07', '2023-08-16 22:13:07', 1, 'N');
INSERT INTO `knowledge_point` (`id`, `point_txt`, `point_level`, `course_id`, `chapter_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (2, '变量是程序中存储数据的基本单元，需要先声明后使用', 1, 1, 1, '2024-03-28 21:19:06', '2024-04-13 21:19:06', 1, 'N');
INSERT INTO `knowledge_point` (`id`, `point_txt`, `point_level`, `course_id`, `chapter_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (3, '循环结构包括 for 循环、while 循环和 do-while 循环', 2, 1, 1, '2021-10-28 21:55:02', '2021-11-21 21:55:02', 1, 'N');

-- ============================================
-- 表：test_paper (3 条数据)
-- ============================================
INSERT INTO `test_paper` (`id`, `paper_title`, `course_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (1, 'Java 基础知识测试卷', 1, '2021-12-05 14:54:06', '2021-12-06 14:54:06', 1, 'N');
INSERT INTO `test_paper` (`id`, `paper_title`, `course_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (2, 'Python 编程能力提升卷', 2, '2020-04-14 09:45:42', '2020-04-22 09:45:42', 1, 'N');
INSERT INTO `test_paper` (`id`, `paper_title`, `course_id`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (3, 'UI 设计综合测试卷', 3, '2021-07-29 08:12:30', '2021-08-10 08:12:30', 1, 'N');

-- ============================================
-- 表：test_paper_question (3 条数据)
-- ============================================
INSERT INTO `test_paper_question` (`id`, `paper_id`, `question_id`, `score`, `create_time`, `deleted`, `publisher_id`) VALUES (1, 1, 1, 10.0, '2023-11-09 21:42:30', 'N', 1);
INSERT INTO `test_paper_question` (`id`, `paper_id`, `question_id`, `score`, `create_time`, `deleted`, `publisher_id`) VALUES (2, 1, 2, 15.0, '2022-05-03 04:42:32', 'N', 1);
INSERT INTO `test_paper_question` (`id`, `paper_id`, `question_id`, `score`, `create_time`, `deleted`, `publisher_id`) VALUES (3, 2, 3, 20.0, '2025-04-19 16:01:23', 'N', 1);

-- ============================================
-- 表：test_point_question (3 条数据)
-- ============================================
INSERT INTO `test_point_question` (`id`, `point_id`, `question_id`, `create_time`, `publisher_id`, `deleted`) VALUES (1, 1, 1, '2024-03-31 13:53:02', 1, 'N');
INSERT INTO `test_point_question` (`id`, `point_id`, `question_id`, `create_time`, `publisher_id`, `deleted`) VALUES (2, 1, 2, '2021-07-18 00:20:31', 1, 'N');
INSERT INTO `test_point_question` (`id`, `point_id`, `question_id`, `create_time`, `publisher_id`, `deleted`) VALUES (3, 2, 3, '2026-10-19 01:21:25', 1, 'N');

-- ============================================
-- 表：test_question_info (3 条数据)
-- ============================================
INSERT INTO `test_question_info` (`id`, `question_txt`, `chapter_id`, `course_id`, `question_type`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (1, 'Java 中以下哪个关键字用于继承？
A. implements
B. extends
C. inherits
D. uses', 1, 1, 1, '2021-07-17 06:44:14', '2021-08-07 06:44:14', 1, 'N');
INSERT INTO `test_question_info` (`id`, `question_txt`, `chapter_id`, `course_id`, `question_type`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (2, 'Python 中如何定义一个函数？
A. function myFunc()
B. def myFunc()
C. func myFunc()
D. define myFunc()', 1, 1, 1, '2026-01-10 18:34:13', '2026-02-05 18:34:13', 1, 'N');
INSERT INTO `test_question_info` (`id`, `question_txt`, `chapter_id`, `course_id`, `question_type`, `create_time`, `update_time`, `publisher_id`, `deleted`) VALUES (3, 'UI 设计中，以下哪个不是色彩三要素？
A. 色相
B. 饱和度
C. 亮度
D. 对比度', 1, 1, 1, '2020-08-15 06:40:33', '2020-08-25 06:40:33', 1, 'N');

-- ============================================
-- 表：test_question_option (3 条数据)
-- ============================================
INSERT INTO `test_question_option` (`id`, `option_txt`, `question_id`, `is_correct`, `create_time`, `update_time`, `deleted`) VALUES (1, 'implements', 1, 'N', '2025-07-21 02:34:21', '2025-08-07 02:34:21', 'N');
INSERT INTO `test_question_option` (`id`, `option_txt`, `question_id`, `is_correct`, `create_time`, `update_time`, `deleted`) VALUES (2, 'extends', 1, 'Y', '2021-12-20 16:57:30', '2021-12-24 16:57:30', 'N');
INSERT INTO `test_question_option` (`id`, `option_txt`, `question_id`, `is_correct`, `create_time`, `update_time`, `deleted`) VALUES (3, 'function myFunc()', 2, 'N', '2026-10-26 23:49:34', '2026-11-12 23:49:34', 'N');

-- ============================================
-- 表：user_info (3 条数据)
-- ============================================
INSERT INTO `user_info` (`id`, `login_name`, `nick_name`, `passwd`, `real_name`, `phone_num`, `email`, `head_img`, `user_level`, `birthday`, `gender`, `create_time`, `operate_time`, `status`) VALUES (1, 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', '张三', '13800138001', 'zhangsan@example.com', 'https://img.example.com/avatar1.jpg', '2', '1990-01-15', 'M', '2019-11-21 16:15:05', '2020-01-02 16:15:05', 'ACTIVE');
INSERT INTO `user_info` (`id`, `login_name`, `nick_name`, `passwd`, `real_name`, `phone_num`, `email`, `head_img`, `user_level`, `birthday`, `gender`, `create_time`, `operate_time`, `status`) VALUES (2, 'lisi', '李四', 'e10adc3949ba59abbe56e057f20f883e', '李四', '13800138002', 'lisi@example.com', 'https://img.example.com/avatar2.jpg', '3', '1992-05-20', 'F', '2018-08-22 01:43:43', '2018-08-31 01:43:43', 'ACTIVE');
INSERT INTO `user_info` (`id`, `login_name`, `nick_name`, `passwd`, `real_name`, `phone_num`, `email`, `head_img`, `user_level`, `birthday`, `gender`, `create_time`, `operate_time`, `status`) VALUES (3, 'wangwu', '王五', 'e10adc3949ba59abbe56e057f20f883e', '王五', '13800138003', 'wangwu@example.com', 'https://img.example.com/avatar3.jpg', '1', '1988-10-08', 'M', '2023-07-08 03:07:47', '2023-09-04 03:07:47', 'ACTIVE');

-- ============================================
-- 表：video_info (3 条数据)
-- ============================================
INSERT INTO `video_info` (`id`, `video_name`, `during_sec`, `video_status`, `video_size`, `video_url`, `video_source_id`, `version_id`, `chapter_id`, `course_id`, `publisher_id`, `create_time`, `update_time`, `deleted`) VALUES (1, 'Java 环境搭建与 Hello World', 1200, 'uploaded', 157286400, 'https://video.example.com/java/01.mp4', 'VID001', 1, 1, 1, 1, '2026-04-29 17:29:19', '2026-05-06 17:29:19', 'N');
INSERT INTO `video_info` (`id`, `video_name`, `during_sec`, `video_status`, `video_size`, `video_url`, `video_source_id`, `version_id`, `chapter_id`, `course_id`, `publisher_id`, `create_time`, `update_time`, `deleted`) VALUES (2, '变量与数据类型详解', 1800, 'uploaded', 209715200, 'https://video.example.com/java/02.mp4', 'VID002', 1, 2, 1, 1, '2020-03-16 20:28:36', '2020-03-26 20:28:36', 'N');
INSERT INTO `video_info` (`id`, `video_name`, `during_sec`, `video_status`, `video_size`, `video_url`, `video_source_id`, `version_id`, `chapter_id`, `course_id`, `publisher_id`, `create_time`, `update_time`, `deleted`) VALUES (3, '面向对象编程基础', 2400, 'uploaded', 262144000, 'https://video.example.com/java/03.mp4', 'VID003', 1, 3, 1, 1, '2024-08-02 12:54:13', '2024-08-08 12:54:13', 'N');
