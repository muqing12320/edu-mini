package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long courseId;
   private String courseName;
   private Long orderId;
   private Long userId;
   private BigDecimal originAmount;
   private BigDecimal couponReduce;
   private BigDecimal finalAmount;
   private Date createTime;
   private Date updateTime;

   public String toString() {
      return "OrderDetail{id=" + this.id + ", courseId=" + this.courseId + ", courseName=" + this.courseName + ", orderId=" + this.orderId + ", userId=" + this.userId + ", originAmount=" + this.originAmount + ", couponReduce=" + this.couponReduce + ", finalAmount=" + this.finalAmount + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public String getCourseName() {
      return this.courseName;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getOriginAmount() {
      return this.originAmount;
   }

   public BigDecimal getCouponReduce() {
      return this.couponReduce;
   }

   public BigDecimal getFinalAmount() {
      return this.finalAmount;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setCourseName(final String courseName) {
      this.courseName = courseName;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setOriginAmount(final BigDecimal originAmount) {
      this.originAmount = originAmount;
   }

   public void setCouponReduce(final BigDecimal couponReduce) {
      this.couponReduce = couponReduce;
   }

   public void setFinalAmount(final BigDecimal finalAmount) {
      this.finalAmount = finalAmount;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OrderDetail)) {
         return false;
      } else {
         OrderDetail other = (OrderDetail)o;
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

            Object this$courseId = this.getCourseId();
            Object other$courseId = other.getCourseId();
            if (this$courseId == null) {
               if (other$courseId != null) {
                  return false;
               }
            } else if (!this$courseId.equals(other$courseId)) {
               return false;
            }

            Object this$courseName = this.getCourseName();
            Object other$courseName = other.getCourseName();
            if (this$courseName == null) {
               if (other$courseName != null) {
                  return false;
               }
            } else if (!this$courseName.equals(other$courseName)) {
               return false;
            }

            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null) {
               if (other$orderId != null) {
                  return false;
               }
            } else if (!this$orderId.equals(other$orderId)) {
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

            Object this$originAmount = this.getOriginAmount();
            Object other$originAmount = other.getOriginAmount();
            if (this$originAmount == null) {
               if (other$originAmount != null) {
                  return false;
               }
            } else if (!this$originAmount.equals(other$originAmount)) {
               return false;
            }

            Object this$couponReduce = this.getCouponReduce();
            Object other$couponReduce = other.getCouponReduce();
            if (this$couponReduce == null) {
               if (other$couponReduce != null) {
                  return false;
               }
            } else if (!this$couponReduce.equals(other$couponReduce)) {
               return false;
            }

            Object this$finalAmount = this.getFinalAmount();
            Object other$finalAmount = other.getFinalAmount();
            if (this$finalAmount == null) {
               if (other$finalAmount != null) {
                  return false;
               }
            } else if (!this$finalAmount.equals(other$finalAmount)) {
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

            Object this$updateTime = this.getUpdateTime();
            Object other$updateTime = other.getUpdateTime();
            if (this$updateTime == null) {
               if (other$updateTime != null) {
                  return false;
               }
            } else if (!this$updateTime.equals(other$updateTime)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OrderDetail;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $courseName = this.getCourseName();
      result = result * 59 + ($courseName == null ? 43 : $courseName.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $originAmount = this.getOriginAmount();
      result = result * 59 + ($originAmount == null ? 43 : $originAmount.hashCode());
      Object $couponReduce = this.getCouponReduce();
      result = result * 59 + ($couponReduce == null ? 43 : $couponReduce.hashCode());
      Object $finalAmount = this.getFinalAmount();
      result = result * 59 + ($finalAmount == null ? 43 : $finalAmount.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      return result;
   }
}
