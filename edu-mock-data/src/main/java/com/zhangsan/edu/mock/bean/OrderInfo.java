package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long userId;
   private BigDecimal originAmount;
   private BigDecimal couponReduce;
   private BigDecimal finalAmount;
   private String orderStatus;
   private String outTradeNo;
   private String tradeBody;
   private Date createTime;
   private Date expireTime;
   private Date updateTime;
   private Long provinceId;
   @TableField(
      exist = false
   )
   private List<OrderDetail> orderDetailList;
   private String sessionId;

   public String toString() {
      return "OrderInfo{id=" + this.id + ", userId=" + this.userId + ", originAmount=" + this.originAmount + ", couponReduce=" + this.couponReduce + ", finalAmount=" + this.finalAmount + ", orderStatus=" + this.orderStatus + ", outTradeNo=" + this.outTradeNo + ", tradeBody=" + this.tradeBody + ", createTime=" + this.createTime + ", expireTime=" + this.expireTime + ", updateTime=" + this.updateTime + "}";
   }

   public String getTradeInfo() {
      String body = "";
      if (this.orderDetailList != null && this.orderDetailList.size() > 0) {
         body = ((OrderDetail)this.orderDetailList.get(0)).getCourseName();
      }

      body = body + "等" + this.orderDetailList.size() + "件商品";
      return body;
   }

   public Long getId() {
      return this.id;
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

   public String getOrderStatus() {
      return this.orderStatus;
   }

   public String getOutTradeNo() {
      return this.outTradeNo;
   }

   public String getTradeBody() {
      return this.tradeBody;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getExpireTime() {
      return this.expireTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public List<OrderDetail> getOrderDetailList() {
      return this.orderDetailList;
   }

   public String getSessionId() {
      return this.sessionId;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setOrderStatus(final String orderStatus) {
      this.orderStatus = orderStatus;
   }

   public void setOutTradeNo(final String outTradeNo) {
      this.outTradeNo = outTradeNo;
   }

   public void setTradeBody(final String tradeBody) {
      this.tradeBody = tradeBody;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setExpireTime(final Date expireTime) {
      this.expireTime = expireTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setOrderDetailList(final List<OrderDetail> orderDetailList) {
      this.orderDetailList = orderDetailList;
   }

   public void setSessionId(final String sessionId) {
      this.sessionId = sessionId;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OrderInfo)) {
         return false;
      } else {
         OrderInfo other = (OrderInfo)o;
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

            Object this$orderStatus = this.getOrderStatus();
            Object other$orderStatus = other.getOrderStatus();
            if (this$orderStatus == null) {
               if (other$orderStatus != null) {
                  return false;
               }
            } else if (!this$orderStatus.equals(other$orderStatus)) {
               return false;
            }

            Object this$outTradeNo = this.getOutTradeNo();
            Object other$outTradeNo = other.getOutTradeNo();
            if (this$outTradeNo == null) {
               if (other$outTradeNo != null) {
                  return false;
               }
            } else if (!this$outTradeNo.equals(other$outTradeNo)) {
               return false;
            }

            Object this$tradeBody = this.getTradeBody();
            Object other$tradeBody = other.getTradeBody();
            if (this$tradeBody == null) {
               if (other$tradeBody != null) {
                  return false;
               }
            } else if (!this$tradeBody.equals(other$tradeBody)) {
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

            Object this$expireTime = this.getExpireTime();
            Object other$expireTime = other.getExpireTime();
            if (this$expireTime == null) {
               if (other$expireTime != null) {
                  return false;
               }
            } else if (!this$expireTime.equals(other$expireTime)) {
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

            Object this$provinceId = this.getProvinceId();
            Object other$provinceId = other.getProvinceId();
            if (this$provinceId == null) {
               if (other$provinceId != null) {
                  return false;
               }
            } else if (!this$provinceId.equals(other$provinceId)) {
               return false;
            }

            Object this$orderDetailList = this.getOrderDetailList();
            Object other$orderDetailList = other.getOrderDetailList();
            if (this$orderDetailList == null) {
               if (other$orderDetailList != null) {
                  return false;
               }
            } else if (!this$orderDetailList.equals(other$orderDetailList)) {
               return false;
            }

            Object this$sessionId = this.getSessionId();
            Object other$sessionId = other.getSessionId();
            if (this$sessionId == null) {
               if (other$sessionId != null) {
                  return false;
               }
            } else if (!this$sessionId.equals(other$sessionId)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OrderInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $originAmount = this.getOriginAmount();
      result = result * 59 + ($originAmount == null ? 43 : $originAmount.hashCode());
      Object $couponReduce = this.getCouponReduce();
      result = result * 59 + ($couponReduce == null ? 43 : $couponReduce.hashCode());
      Object $finalAmount = this.getFinalAmount();
      result = result * 59 + ($finalAmount == null ? 43 : $finalAmount.hashCode());
      Object $orderStatus = this.getOrderStatus();
      result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
      Object $outTradeNo = this.getOutTradeNo();
      result = result * 59 + ($outTradeNo == null ? 43 : $outTradeNo.hashCode());
      Object $tradeBody = this.getTradeBody();
      result = result * 59 + ($tradeBody == null ? 43 : $tradeBody.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $expireTime = this.getExpireTime();
      result = result * 59 + ($expireTime == null ? 43 : $expireTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $orderDetailList = this.getOrderDetailList();
      result = result * 59 + ($orderDetailList == null ? 43 : $orderDetailList.hashCode());
      Object $sessionId = this.getSessionId();
      result = result * 59 + ($sessionId == null ? 43 : $sessionId.hashCode());
      return result;
   }
}
