package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String outTradeNo;
   private Long orderId;
   private String alipayTradeNo;
   private BigDecimal totalAmount;
   private String tradeBody;
   private String paymentStatus;
   private String paymentType;
   private Date createTime;
   private Date updateTime;
   private String callbackContent;
   private Date callbackTime;

   public String toString() {
      return "PaymentInfo{id=" + this.id + ", outTradeNo=" + this.outTradeNo + ", orderId=" + this.orderId + ", alipayTradeNo=" + this.alipayTradeNo + ", totalAmount=" + this.totalAmount + ", tradeBody=" + this.tradeBody + ", paymentStatus=" + this.paymentStatus + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", callbackContent=" + this.callbackContent + ", callbackTime=" + this.callbackTime + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getOutTradeNo() {
      return this.outTradeNo;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getAlipayTradeNo() {
      return this.alipayTradeNo;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public String getTradeBody() {
      return this.tradeBody;
   }

   public String getPaymentStatus() {
      return this.paymentStatus;
   }

   public String getPaymentType() {
      return this.paymentType;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public String getCallbackContent() {
      return this.callbackContent;
   }

   public Date getCallbackTime() {
      return this.callbackTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOutTradeNo(final String outTradeNo) {
      this.outTradeNo = outTradeNo;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setAlipayTradeNo(final String alipayTradeNo) {
      this.alipayTradeNo = alipayTradeNo;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setTradeBody(final String tradeBody) {
      this.tradeBody = tradeBody;
   }

   public void setPaymentStatus(final String paymentStatus) {
      this.paymentStatus = paymentStatus;
   }

   public void setPaymentType(final String paymentType) {
      this.paymentType = paymentType;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setCallbackContent(final String callbackContent) {
      this.callbackContent = callbackContent;
   }

   public void setCallbackTime(final Date callbackTime) {
      this.callbackTime = callbackTime;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PaymentInfo)) {
         return false;
      } else {
         PaymentInfo other = (PaymentInfo)o;
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

            Object this$outTradeNo = this.getOutTradeNo();
            Object other$outTradeNo = other.getOutTradeNo();
            if (this$outTradeNo == null) {
               if (other$outTradeNo != null) {
                  return false;
               }
            } else if (!this$outTradeNo.equals(other$outTradeNo)) {
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

            Object this$alipayTradeNo = this.getAlipayTradeNo();
            Object other$alipayTradeNo = other.getAlipayTradeNo();
            if (this$alipayTradeNo == null) {
               if (other$alipayTradeNo != null) {
                  return false;
               }
            } else if (!this$alipayTradeNo.equals(other$alipayTradeNo)) {
               return false;
            }

            Object this$totalAmount = this.getTotalAmount();
            Object other$totalAmount = other.getTotalAmount();
            if (this$totalAmount == null) {
               if (other$totalAmount != null) {
                  return false;
               }
            } else if (!this$totalAmount.equals(other$totalAmount)) {
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

            Object this$paymentStatus = this.getPaymentStatus();
            Object other$paymentStatus = other.getPaymentStatus();
            if (this$paymentStatus == null) {
               if (other$paymentStatus != null) {
                  return false;
               }
            } else if (!this$paymentStatus.equals(other$paymentStatus)) {
               return false;
            }

            Object this$paymentType = this.getPaymentType();
            Object other$paymentType = other.getPaymentType();
            if (this$paymentType == null) {
               if (other$paymentType != null) {
                  return false;
               }
            } else if (!this$paymentType.equals(other$paymentType)) {
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

            Object this$callbackContent = this.getCallbackContent();
            Object other$callbackContent = other.getCallbackContent();
            if (this$callbackContent == null) {
               if (other$callbackContent != null) {
                  return false;
               }
            } else if (!this$callbackContent.equals(other$callbackContent)) {
               return false;
            }

            Object this$callbackTime = this.getCallbackTime();
            Object other$callbackTime = other.getCallbackTime();
            if (this$callbackTime == null) {
               if (other$callbackTime != null) {
                  return false;
               }
            } else if (!this$callbackTime.equals(other$callbackTime)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaymentInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outTradeNo = this.getOutTradeNo();
      result = result * 59 + ($outTradeNo == null ? 43 : $outTradeNo.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $alipayTradeNo = this.getAlipayTradeNo();
      result = result * 59 + ($alipayTradeNo == null ? 43 : $alipayTradeNo.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $tradeBody = this.getTradeBody();
      result = result * 59 + ($tradeBody == null ? 43 : $tradeBody.hashCode());
      Object $paymentStatus = this.getPaymentStatus();
      result = result * 59 + ($paymentStatus == null ? 43 : $paymentStatus.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $callbackContent = this.getCallbackContent();
      result = result * 59 + ($callbackContent == null ? 43 : $callbackContent.hashCode());
      Object $callbackTime = this.getCallbackTime();
      result = result * 59 + ($callbackTime == null ? 43 : $callbackTime.hashCode());
      return result;
   }
}
