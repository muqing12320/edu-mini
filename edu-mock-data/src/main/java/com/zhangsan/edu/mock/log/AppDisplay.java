package com.zhangsan.edu.mock.log;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.log.enums.DisplayType;
import com.zhangsan.edu.mock.log.enums.ItemType;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;
import java.util.ArrayList;
import java.util.List;

public class AppDisplay {
   ItemType item_type;
   String item;
   DisplayType display_type;
   Integer order;
   Integer pos_id;

   public static List<AppDisplay> buildList() {
      List<AppDisplay> displayList = new ArrayList();
      int displayCount = RandomNum.getRandInt(AppConfig.min_display_count, AppConfig.max_display_count);
      int activityCount = displayList.size();

      for(int i = 1 + activityCount; i <= displayCount + activityCount; ++i) {
         int skuId = RandomNum.getRandInt(1, AppConfig.max_course_id);
         int pos_id = RandomNum.getRandInt(1, AppConfig.max_pos_id);
         RandomBox<DisplayType> dispTypeGroup = RandomBox.builder().add(DisplayType.promotion, 30).add(DisplayType.query, 60).add(DisplayType.recommend, 10).build();
         DisplayType displayType = (DisplayType)dispTypeGroup.getValue();
         AppDisplay appDisplay = new AppDisplay(ItemType.course_id, skuId + "", displayType, i, pos_id);
         displayList.add(appDisplay);
      }

      return displayList;
   }

   public ItemType getItem_type() {
      return this.item_type;
   }

   public String getItem() {
      return this.item;
   }

   public DisplayType getDisplay_type() {
      return this.display_type;
   }

   public Integer getOrder() {
      return this.order;
   }

   public Integer getPos_id() {
      return this.pos_id;
   }

   public void setItem_type(final ItemType item_type) {
      this.item_type = item_type;
   }

   public void setItem(final String item) {
      this.item = item;
   }

   public void setDisplay_type(final DisplayType display_type) {
      this.display_type = display_type;
   }

   public void setOrder(final Integer order) {
      this.order = order;
   }

   public void setPos_id(final Integer pos_id) {
      this.pos_id = pos_id;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppDisplay)) {
         return false;
      } else {
         AppDisplay other = (AppDisplay)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
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

            Object this$display_type = this.getDisplay_type();
            Object other$display_type = other.getDisplay_type();
            if (this$display_type == null) {
               if (other$display_type != null) {
                  return false;
               }
            } else if (!this$display_type.equals(other$display_type)) {
               return false;
            }

            Object this$order = this.getOrder();
            Object other$order = other.getOrder();
            if (this$order == null) {
               if (other$order != null) {
                  return false;
               }
            } else if (!this$order.equals(other$order)) {
               return false;
            }

            Object this$pos_id = this.getPos_id();
            Object other$pos_id = other.getPos_id();
            if (this$pos_id == null) {
               if (other$pos_id != null) {
                  return false;
               }
            } else if (!this$pos_id.equals(other$pos_id)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppDisplay;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $item_type = this.getItem_type();
      result = result * 59 + ($item_type == null ? 43 : $item_type.hashCode());
      Object $item = this.getItem();
      result = result * 59 + ($item == null ? 43 : $item.hashCode());
      Object $display_type = this.getDisplay_type();
      result = result * 59 + ($display_type == null ? 43 : $display_type.hashCode());
      Object $order = this.getOrder();
      result = result * 59 + ($order == null ? 43 : $order.hashCode());
      Object $pos_id = this.getPos_id();
      result = result * 59 + ($pos_id == null ? 43 : $pos_id.hashCode());
      return result;
   }

   public String toString() {
      return "AppDisplay(item_type=" + this.getItem_type() + ", item=" + this.getItem() + ", display_type=" + this.getDisplay_type() + ", order=" + this.getOrder() + ", pos_id=" + this.getPos_id() + ")";
   }

   public AppDisplay(final ItemType item_type, final String item, final DisplayType display_type, final Integer order, final Integer pos_id) {
      this.item_type = item_type;
      this.item = item;
      this.display_type = display_type;
      this.order = order;
      this.pos_id = pos_id;
   }
}
