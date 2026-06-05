package com.zhangsan.edu.mock.log;

import com.zhangsan.edu.mock.log.enums.DisplayType;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.log.enums.PageId;
import com.zhangsan.edu.mock.util.RandomNum;

public class AppPage {
   PageId last_page_id;
   PageId page_id;
   ItemType item_type;
   String item;
   Integer during_time;
   String extend1;
   String extend2;
   DisplayType source_type;

   public static void main(String[] args) {
      AppPage appPage = builder().page_id(PageId.home).build();
      System.out.println(appPage.toString());
   }

   private static Integer $default$during_time() {
      return RandomNum.getRandInt(5000, 15000);
   }

   public static AppPageBuilder builder() {
      return new AppPageBuilder();
   }

   public PageId getLast_page_id() {
      return this.last_page_id;
   }

   public PageId getPage_id() {
      return this.page_id;
   }

   public ItemType getItem_type() {
      return this.item_type;
   }

   public String getItem() {
      return this.item;
   }

   public Integer getDuring_time() {
      return this.during_time;
   }

   public String getExtend1() {
      return this.extend1;
   }

   public String getExtend2() {
      return this.extend2;
   }

   public DisplayType getSource_type() {
      return this.source_type;
   }

   public void setLast_page_id(final PageId last_page_id) {
      this.last_page_id = last_page_id;
   }

   public void setPage_id(final PageId page_id) {
      this.page_id = page_id;
   }

   public void setItem_type(final ItemType item_type) {
      this.item_type = item_type;
   }

   public void setItem(final String item) {
      this.item = item;
   }

   public void setDuring_time(final Integer during_time) {
      this.during_time = during_time;
   }

   public void setExtend1(final String extend1) {
      this.extend1 = extend1;
   }

   public void setExtend2(final String extend2) {
      this.extend2 = extend2;
   }

   public void setSource_type(final DisplayType source_type) {
      this.source_type = source_type;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppPage)) {
         return false;
      } else {
         AppPage other = (AppPage)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$last_page_id = this.getLast_page_id();
            Object other$last_page_id = other.getLast_page_id();
            if (this$last_page_id == null) {
               if (other$last_page_id != null) {
                  return false;
               }
            } else if (!this$last_page_id.equals(other$last_page_id)) {
               return false;
            }

            Object this$page_id = this.getPage_id();
            Object other$page_id = other.getPage_id();
            if (this$page_id == null) {
               if (other$page_id != null) {
                  return false;
               }
            } else if (!this$page_id.equals(other$page_id)) {
               return false;
            }

            Object this$item_type = this.getItem_type();
            Object other$item_type = other.getItem_type();
            if (this$item_type == null) {
               if (other$item_type != null) {
                  return false;
               }
            } else if (!this$item_type.equals(other$item_type)) {
               return false;
            }

            Object this$item = this.getItem();
            Object other$item = other.getItem();
            if (this$item == null) {
               if (other$item != null) {
                  return false;
               }
            } else if (!this$item.equals(other$item)) {
               return false;
            }

            Object this$during_time = this.getDuring_time();
            Object other$during_time = other.getDuring_time();
            if (this$during_time == null) {
               if (other$during_time != null) {
                  return false;
               }
            } else if (!this$during_time.equals(other$during_time)) {
               return false;
            }

            Object this$extend1 = this.getExtend1();
            Object other$extend1 = other.getExtend1();
            if (this$extend1 == null) {
               if (other$extend1 != null) {
                  return false;
               }
            } else if (!this$extend1.equals(other$extend1)) {
               return false;
            }

            Object this$extend2 = this.getExtend2();
            Object other$extend2 = other.getExtend2();
            if (this$extend2 == null) {
               if (other$extend2 != null) {
                  return false;
               }
            } else if (!this$extend2.equals(other$extend2)) {
               return false;
            }

            Object this$source_type = this.getSource_type();
            Object other$source_type = other.getSource_type();
            if (this$source_type == null) {
               if (other$source_type != null) {
                  return false;
               }
            } else if (!this$source_type.equals(other$source_type)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppPage;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $last_page_id = this.getLast_page_id();
      result = result * 59 + ($last_page_id == null ? 43 : $last_page_id.hashCode());
      Object $page_id = this.getPage_id();
      result = result * 59 + ($page_id == null ? 43 : $page_id.hashCode());
      Object $item_type = this.getItem_type();
      result = result * 59 + ($item_type == null ? 43 : $item_type.hashCode());
      Object $item = this.getItem();
      result = result * 59 + ($item == null ? 43 : $item.hashCode());
      Object $during_time = this.getDuring_time();
      result = result * 59 + ($during_time == null ? 43 : $during_time.hashCode());
      Object $extend1 = this.getExtend1();
      result = result * 59 + ($extend1 == null ? 43 : $extend1.hashCode());
      Object $extend2 = this.getExtend2();
      result = result * 59 + ($extend2 == null ? 43 : $extend2.hashCode());
      Object $source_type = this.getSource_type();
      result = result * 59 + ($source_type == null ? 43 : $source_type.hashCode());
      return result;
   }

   public String toString() {
      return "AppPage(last_page_id=" + this.getLast_page_id() + ", page_id=" + this.getPage_id() + ", item_type=" + this.getItem_type() + ", item=" + this.getItem() + ", during_time=" + this.getDuring_time() + ", extend1=" + this.getExtend1() + ", extend2=" + this.getExtend2() + ", source_type=" + this.getSource_type() + ")";
   }

   public AppPage(final PageId last_page_id, final PageId page_id, final ItemType item_type, final String item, final Integer during_time, final String extend1, final String extend2, final DisplayType source_type) {
      this.last_page_id = last_page_id;
      this.page_id = page_id;
      this.item_type = item_type;
      this.item = item;
      this.during_time = during_time;
      this.extend1 = extend1;
      this.extend2 = extend2;
      this.source_type = source_type;
   }

   public static class AppPageBuilder {
      private PageId last_page_id;
      private PageId page_id;
      private ItemType item_type;
      private String item;
      private boolean during_time$set;
      private Integer during_time;
      private String extend1;
      private String extend2;
      private DisplayType source_type;

      AppPageBuilder() {
      }

      public AppPageBuilder last_page_id(final PageId last_page_id) {
         this.last_page_id = last_page_id;
         return this;
      }

      public AppPageBuilder page_id(final PageId page_id) {
         this.page_id = page_id;
         return this;
      }

      public AppPageBuilder item_type(final ItemType item_type) {
         this.item_type = item_type;
         return this;
      }

      public AppPageBuilder item(final String item) {
         this.item = item;
         return this;
      }

      public AppPageBuilder during_time(final Integer during_time) {
         this.during_time = during_time;
         this.during_time$set = true;
         return this;
      }

      public AppPageBuilder extend1(final String extend1) {
         this.extend1 = extend1;
         return this;
      }

      public AppPageBuilder extend2(final String extend2) {
         this.extend2 = extend2;
         return this;
      }

      public AppPageBuilder source_type(final DisplayType source_type) {
         this.source_type = source_type;
         return this;
      }

      public AppPage build() {
         Integer during_time = this.during_time;
         if (!this.during_time$set) {
            during_time = AppPage.$default$during_time();
         }

         return new AppPage(this.last_page_id, this.page_id, this.item_type, this.item, during_time, this.extend1, this.extend2, this.source_type);
      }

      public String toString() {
         return "AppPage.AppPageBuilder(last_page_id=" + this.last_page_id + ", page_id=" + this.page_id + ", item_type=" + this.item_type + ", item=" + this.item + ", during_time=" + this.during_time + ", extend1=" + this.extend1 + ", extend2=" + this.extend2 + ", source_type=" + this.source_type + ")";
      }
   }
}
