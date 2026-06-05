package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class KnowledgePoint implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String pointTxt;
   private Integer pointLevel;
   private Long courseId;
   private Long chapterId;
   private Date createTime;
   private Date updateTime;
   private Long publisherId;
   private String deleted;

   public String toString() {
      return "KnowledgePoint{id=" + this.id + ", pointTxt=" + this.pointTxt + ", pointLevel=" + this.pointLevel + ", courseId=" + this.courseId + ", chapterId=" + this.chapterId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", publisherId=" + this.publisherId + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getPointTxt() {
      return this.pointTxt;
   }

   public Integer getPointLevel() {
      return this.pointLevel;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public Long getChapterId() {
      return this.chapterId;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public Long getPublisherId() {
      return this.publisherId;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPointTxt(final String pointTxt) {
      this.pointTxt = pointTxt;
   }

   public void setPointLevel(final Integer pointLevel) {
      this.pointLevel = pointLevel;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setChapterId(final Long chapterId) {
      this.chapterId = chapterId;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setPublisherId(final Long publisherId) {
      this.publisherId = publisherId;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof KnowledgePoint)) {
         return false;
      } else {
         KnowledgePoint other = (KnowledgePoint)o;
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

            Object this$pointTxt = this.getPointTxt();
            Object other$pointTxt = other.getPointTxt();
            if (this$pointTxt == null) {
               if (other$pointTxt != null) {
                  return false;
               }
            } else if (!this$pointTxt.equals(other$pointTxt)) {
               return false;
            }

            Object this$pointLevel = this.getPointLevel();
            Object other$pointLevel = other.getPointLevel();
            if (this$pointLevel == null) {
               if (other$pointLevel != null) {
                  return false;
               }
            } else if (!this$pointLevel.equals(other$pointLevel)) {
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

            Object this$chapterId = this.getChapterId();
            Object other$chapterId = other.getChapterId();
            if (this$chapterId == null) {
               if (other$chapterId != null) {
                  return false;
               }
            } else if (!this$chapterId.equals(other$chapterId)) {
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

            Object this$publisherId = this.getPublisherId();
            Object other$publisherId = other.getPublisherId();
            if (this$publisherId == null) {
               if (other$publisherId != null) {
                  return false;
               }
            } else if (!this$publisherId.equals(other$publisherId)) {
               return false;
            }

            Object this$deleted = this.getDeleted();
            Object other$deleted = other.getDeleted();
            if (this$deleted == null) {
               if (other$deleted != null) {
                  return false;
               }
            } else if (!this$deleted.equals(other$deleted)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof KnowledgePoint;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pointTxt = this.getPointTxt();
      result = result * 59 + ($pointTxt == null ? 43 : $pointTxt.hashCode());
      Object $pointLevel = this.getPointLevel();
      result = result * 59 + ($pointLevel == null ? 43 : $pointLevel.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $chapterId = this.getChapterId();
      result = result * 59 + ($chapterId == null ? 43 : $chapterId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      return result;
   }
}
