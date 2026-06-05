package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CartInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long userId;
   private Long courseId;
   private String courseName;
   private BigDecimal cartPrice;
   private String imgUrl;
   private String sessionId;
   private Date createTime;
   private Date updateTime;
   private String deleted;
   private String sold;

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public void setCourseId(Long courseId) {
      this.courseId = courseId;
   }

   public String getCourseName() {
      return this.courseName;
   }

   public void setCourseName(String courseName) {
      this.courseName = courseName;
   }

   public BigDecimal getCartPrice() {
      return this.cartPrice;
   }

   public void setCartPrice(BigDecimal cartPrice) {
      this.cartPrice = cartPrice;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public String getSessionId() {
      return this.sessionId;
   }

   public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setDeleted(String deleted) {
      this.deleted = deleted;
   }

   public String getSold() {
      return this.sold;
   }

   public void setSold(String sold) {
      this.sold = sold;
   }

   public String toString() {
      return "CartInfo{id=" + this.id + ", userId=" + this.userId + ", courseId=" + this.courseId + ", courseName=" + this.courseName + ", cartPrice=" + this.cartPrice + ", imgUrl=" + this.imgUrl + ", sessionId=" + this.sessionId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + ", sold=" + this.sold + "}";
   }
}
