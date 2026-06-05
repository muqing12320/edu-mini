package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class UserChapterProcess implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long courseId;
   private Long chapterId;
   private Long userId;
   private Integer positionSec;
   private Date createTime;
   private Date updateTime;
   private String deleted;

   public String toString() {
      return "UserChapterProcess{id=" + this.id + ", courseId=" + this.courseId + ", chapterId=" + this.chapterId + ", userId=" + this.userId + ", positionSec=" + this.positionSec + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public Long getChapterId() {
      return this.chapterId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getPositionSec() {
      return this.positionSec;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setChapterId(final Long chapterId) {
      this.chapterId = chapterId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setPositionSec(final Integer positionSec) {
      this.positionSec = positionSec;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserChapterProcess)) {
         return false;
      } else {
         UserChapterProcess other = (UserChapterProcess)o;
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

            Object this$chapterId = this.getChapterId();
            Object other$chapterId = other.getChapterId();
            if (this$chapterId == null) {
               if (other$chapterId != null) {
                  return false;
               }
            } else if (!this$chapterId.equals(other$chapterId)) {
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

            Object this$positionSec = this.getPositionSec();
            Object other$positionSec = other.getPositionSec();
            if (this$positionSec == null) {
               if (other$positionSec != null) {
                  return false;
               }
            } else if (!this$positionSec.equals(other$positionSec)) {
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
      return other instanceof UserChapterProcess;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $chapterId = this.getChapterId();
      result = result * 59 + ($chapterId == null ? 43 : $chapterId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $positionSec = this.getPositionSec();
      result = result * 59 + ($positionSec == null ? 43 : $positionSec.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      return result;
   }
}
