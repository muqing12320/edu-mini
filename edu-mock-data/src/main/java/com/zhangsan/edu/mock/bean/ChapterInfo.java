package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class ChapterInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String chapterName;
   private Long courseId;
   private Long videoId;
   private Long publisherId;
   private String isFree;
   private Date createTime;
   private String deleted;
   private Date updateTime;
   @TableField(
      exist = false
   )
   private VideoInfo videoInfo;

   public String toString() {
      return "ChapterInfo{id=" + this.id + ", chapterName=" + this.chapterName + ", courseId=" + this.courseId + ", videoId=" + this.videoId + ", publisherId=" + this.publisherId + ", isFree=" + this.isFree + ", createTime=" + this.createTime + ", deleted=" + this.deleted + ", updateTime=" + this.updateTime + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getChapterName() {
      return this.chapterName;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public Long getVideoId() {
      return this.videoId;
   }

   public Long getPublisherId() {
      return this.publisherId;
   }

   public String getIsFree() {
      return this.isFree;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public VideoInfo getVideoInfo() {
      return this.videoInfo;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setChapterName(final String chapterName) {
      this.chapterName = chapterName;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setVideoId(final Long videoId) {
      this.videoId = videoId;
   }

   public void setPublisherId(final Long publisherId) {
      this.publisherId = publisherId;
   }

   public void setIsFree(final String isFree) {
      this.isFree = isFree;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setVideoInfo(final VideoInfo videoInfo) {
      this.videoInfo = videoInfo;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ChapterInfo)) {
         return false;
      } else {
         ChapterInfo other = (ChapterInfo)o;
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

            Object this$chapterName = this.getChapterName();
            Object other$chapterName = other.getChapterName();
            if (this$chapterName == null) {
               if (other$chapterName != null) {
                  return false;
               }
            } else if (!this$chapterName.equals(other$chapterName)) {
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

            Object this$videoId = this.getVideoId();
            Object other$videoId = other.getVideoId();
            if (this$videoId == null) {
               if (other$videoId != null) {
                  return false;
               }
            } else if (!this$videoId.equals(other$videoId)) {
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

            Object this$isFree = this.getIsFree();
            Object other$isFree = other.getIsFree();
            if (this$isFree == null) {
               if (other$isFree != null) {
                  return false;
               }
            } else if (!this$isFree.equals(other$isFree)) {
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

            Object this$updateTime = this.getUpdateTime();
            Object other$updateTime = other.getUpdateTime();
            if (this$updateTime == null) {
               if (other$updateTime != null) {
                  return false;
               }
            } else if (!this$updateTime.equals(other$updateTime)) {
               return false;
            }

            Object this$videoInfo = this.getVideoInfo();
            Object other$videoInfo = other.getVideoInfo();
            if (this$videoInfo == null) {
               if (other$videoInfo != null) {
                  return false;
               }
            } else if (!this$videoInfo.equals(other$videoInfo)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChapterInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $chapterName = this.getChapterName();
      result = result * 59 + ($chapterName == null ? 43 : $chapterName.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $videoId = this.getVideoId();
      result = result * 59 + ($videoId == null ? 43 : $videoId.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $isFree = this.getIsFree();
      result = result * 59 + ($isFree == null ? 43 : $isFree.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $videoInfo = this.getVideoInfo();
      result = result * 59 + ($videoInfo == null ? 43 : $videoInfo.hashCode());
      return result;
   }
}
