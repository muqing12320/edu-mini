package com.zhangsan.edu.mock.log;

import com.zhangsan.edu.mock.log.enums.ActionId;
import com.zhangsan.edu.mock.log.enums.ItemType;

public class AppAction {
   ActionId action_id;
   ItemType item_type;
   String item;
   String extend1;
   String extend2;
   Long ts;

   public AppAction(ActionId action_id, ItemType item_type, String item, Long ts) {
      this.action_id = action_id;
      this.item_type = item_type;
      this.item = item;
      this.ts = ts;
   }

   private AppAction() {
   }

   public ActionId getAction_id() {
      return this.action_id;
   }

   public ItemType getItem_type() {
      return this.item_type;
   }

   public String getItem() {
      return this.item;
   }

   public String getExtend1() {
      return this.extend1;
   }

   public String getExtend2() {
      return this.extend2;
   }

   public Long getTs() {
      return this.ts;
   }

   public void setAction_id(final ActionId action_id) {
      this.action_id = action_id;
   }

   public void setItem_type(final ItemType item_type) {
      this.item_type = item_type;
   }

   public void setItem(final String item) {
      this.item = item;
   }

   public void setExtend1(final String extend1) {
      this.extend1 = extend1;
   }

   public void setExtend2(final String extend2) {
      this.extend2 = extend2;
   }

   public void setTs(final Long ts) {
      this.ts = ts;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppAction)) {
         return false;
      } else {
         AppAction other = (AppAction)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$action_id = this.getAction_id();
            Object other$action_id = other.getAction_id();
            if (this$action_id == null) {
               if (other$action_id != null) {
                  return false;
               }
            } else if (!this$action_id.equals(other$action_id)) {
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

            Object this$ts = this.getTs();
            Object other$ts = other.getTs();
            if (this$ts == null) {
               if (other$ts != null) {
                  return false;
               }
            } else if (!this$ts.equals(other$ts)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppAction;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $action_id = this.getAction_id();
      result = result * 59 + ($action_id == null ? 43 : $action_id.hashCode());
      Object $item_type = this.getItem_type();
      result = result * 59 + ($item_type == null ? 43 : $item_type.hashCode());
      Object $item = this.getItem();
      result = result * 59 + ($item == null ? 43 : $item.hashCode());
      Object $extend1 = this.getExtend1();
      result = result * 59 + ($extend1 == null ? 43 : $extend1.hashCode());
      Object $extend2 = this.getExtend2();
      result = result * 59 + ($extend2 == null ? 43 : $extend2.hashCode());
      Object $ts = this.getTs();
      result = result * 59 + ($ts == null ? 43 : $ts.hashCode());
      return result;
   }

   public String toString() {
      return "AppAction(action_id=" + this.getAction_id() + ", item_type=" + this.getItem_type() + ", item=" + this.getItem() + ", extend1=" + this.getExtend1() + ", extend2=" + this.getExtend2() + ", ts=" + this.getTs() + ")";
   }
}
