package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class ReviewInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long userId;
   private Long courseId;
   private String reviewTxt;
   private Integer reviewStars;
   private Date createTime;
   private String deleted;

   public String toString() {
      return "ReviewInfo{id=" + this.id + ", userId=" + this.userId + ", courseId=" + this.courseId + ", reviewTxt=" + this.reviewTxt + ", reviewStars=" + this.reviewStars + ", createTime=" + this.createTime + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public String getReviewTxt() {
      return this.reviewTxt;
   }

   public Integer getReviewStars() {
      return this.reviewStars;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setReviewTxt(final String reviewTxt) {
      this.reviewTxt = reviewTxt;
   }

   public void setReviewStars(final Integer reviewStars) {
      this.reviewStars = reviewStars;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReviewInfo)) {
         return false;
      } else {
         ReviewInfo other = (ReviewInfo)o;
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

            Object this$courseId = this.getCourseId();
            Object other$courseId = other.getCourseId();
            if (this$courseId == null) {
               if (other$courseId != null) {
                  return false;
               }
            } else if (!this$courseId.equals(other$courseId)) {
               return false;
            }

            Object this$reviewTxt = this.getReviewTxt();
            Object other$reviewTxt = other.getReviewTxt();
            if (this$reviewTxt == null) {
               if (other$reviewTxt != null) {
                  return false;
               }
            } else if (!this$reviewTxt.equals(other$reviewTxt)) {
               return false;
            }

            Object this$reviewStars = this.getReviewStars();
            Object other$reviewStars = other.getReviewStars();
            if (this$reviewStars == null) {
               if (other$reviewStars != null) {
                  return false;
               }
            } else if (!this$reviewStars.equals(other$reviewStars)) {
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
      return other instanceof ReviewInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $reviewTxt = this.getReviewTxt();
      result = result * 59 + ($reviewTxt == null ? 43 : $reviewTxt.hashCode());
      Object $reviewStars = this.getReviewStars();
      result = result * 59 + ($reviewStars == null ? 43 : $reviewStars.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      return result;
   }
}
