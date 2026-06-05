package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class VipChangeDetail implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long userId;
   private Integer fromVip;
   private Integer toVip;
   private Date createTime;

   public String toString() {
      return "VipChangeDetail{id=" + this.id + ", userId=" + this.userId + ", fromVip=" + this.fromVip + ", toVip=" + this.toVip + ", createTime=" + this.createTime + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getFromVip() {
      return this.fromVip;
   }

   public Integer getToVip() {
      return this.toVip;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setFromVip(final Integer fromVip) {
      this.fromVip = fromVip;
   }

   public void setToVip(final Integer toVip) {
      this.toVip = toVip;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof VipChangeDetail)) {
         return false;
      } else {
         VipChangeDetail other = (VipChangeDetail)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null) {
               if (other$id != null) {
                  return false;
               }
            } else if (!this$id.equals(other$id)) {
               return false;
            }

            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null) {
               if (other$userId != null) {
                  return false;
               }
            } else if (!this$userId.equals(other$userId)) {
               return false;
            }

            Object this$fromVip = this.getFromVip();
            Object other$fromVip = other.getFromVip();
            if (this$fromVip == null) {
               if (other$fromVip != null) {
                  return false;
               }
            } else if (!this$fromVip.equals(other$fromVip)) {
               return false;
            }

            Object this$toVip = this.getToVip();
            Object other$toVip = other.getToVip();
            if (this$toVip == null) {
               if (other$toVip != null) {
                  return false;
               }
            } else if (!this$toVip.equals(other$toVip)) {
               return false;
            }

            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null) {
               if (other$createTime != null) {
                  return false;
               }
            } else if (!this$createTime.equals(other$createTime)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof VipChangeDetail;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $fromVip = this.getFromVip();
      result = result * 59 + ($fromVip == null ? 43 : $fromVip.hashCode());
      Object $toVip = this.getToVip();
      result = result * 59 + ($toVip == null ? 43 : $toVip.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      return result;
   }
}
