package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class TestPointQuestion implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long pointId;
   private Long questionId;
   private Date createTime;
   private Long publisherId;
   private String deleted;

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getPointId() {
      return this.pointId;
   }

   public void setPointId(Long pointId) {
      this.pointId = pointId;
   }

   public Long getQuestionId() {
      return this.questionId;
   }

   public void setQuestionId(Long questionId) {
      this.questionId = questionId;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   public Long getPublisherId() {
      return this.publisherId;
   }

   public void setPublisherId(Long publisherId) {
      this.publisherId = publisherId;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setDeleted(String deleted) {
      this.deleted = deleted;
   }

   public String toString() {
      return "TestPointQuestion{id=" + this.id + ", pointId=" + this.pointId + ", questionId=" + this.questionId + ", createTime=" + this.createTime + ", publisherId=" + this.publisherId + ", deleted=" + this.deleted + "}";
   }
}
