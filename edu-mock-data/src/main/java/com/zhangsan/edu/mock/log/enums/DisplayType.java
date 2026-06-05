package com.zhangsan.edu.mock.log.enums;

public enum DisplayType {
   promotion("商品推广"),
   recommend("算法推荐商品"),
   query("查询结果商品"),
   activity("促销活动");

   private String desc;

   private DisplayType(final String desc) {
      this.desc = desc;
   }
}
