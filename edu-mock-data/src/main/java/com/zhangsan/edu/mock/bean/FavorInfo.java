package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class FavorInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long courseId;
   private Long userId;
   private Date createTime;
   private Date updateTime;
   private String deleted;

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public void setCourseId(Long courseId) {
      this.courseId = courseId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
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

   public String toString() {
      return "FavorInfo{id=" + this.id + ", courseId=" + this.courseId + ", userId=" + this.userId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }
}
