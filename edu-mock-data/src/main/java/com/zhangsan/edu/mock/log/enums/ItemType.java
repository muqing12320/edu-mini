package com.zhangsan.edu.mock.log.enums;

public enum ItemType {
   course_id("课程Id"),
   keyword("搜索关键词"),
   video_id("视频id"),
   chapter_id("章节id"),
   coupon_id("购物券id"),
   order_id("订单id"),
   paper_id("考卷id"),
   exam_id("考试id");

   String desc;

   private ItemType(String desc) {
      this.desc = desc;
   }
}
