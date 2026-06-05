package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class CommentInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long userId;
   private Long chapterId;
   private Long courseId;
   private String commentTxt;
   private Date createTime;
   private String deleted;

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

   public Long getChapterId() {
      return this.chapterId;
   }

   public void setChapterId(Long chapterId) {
      this.chapterId = chapterId;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public void setCourseId(Long courseId) {
      this.courseId = courseId;
   }

   public String getCommentTxt() {
      return this.commentTxt;
   }

   public void setCommentTxt(String commentTxt) {
      this.commentTxt = commentTxt;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setDeleted(String deleted) {
      this.deleted = deleted;
   }

   public String toString() {
      return "CommentInfo{id=" + this.id + ", userId=" + this.userId + ", chapterId=" + this.chapterId + ", courseId=" + this.courseId + ", commentTxt=" + this.commentTxt + ", createTime=" + this.createTime + ", deleted=" + this.deleted + "}";
   }
}
