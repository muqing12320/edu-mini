package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class VideoInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String videoName;
   private Integer duringSec;
   private String videoStatus;
   private Long videoSize;
   private String videoUrl;
   private String videoSourceId;
   private Long versionId;
   private Long chapterId;
   private Long courseId;
   private Long publisherId;
   private Date createTime;
   private Date updateTime;
   private String deleted;

   public Long getId() {
      return this.id;
   }

   public String getVideoName() {
      return this.videoName;
   }

   public Integer getDuringSec() {
      return this.duringSec;
   }

   public String getVideoStatus() {
      return this.videoStatus;
   }

   public Long getVideoSize() {
      return this.videoSize;
   }

   public String getVideoUrl() {
      return this.videoUrl;
   }

   public String getVideoSourceId() {
      return this.videoSourceId;
   }

   public Long getVersionId() {
      return this.versionId;
   }

   public Long getChapterId() {
      return this.chapterId;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public Long getPublisherId() {
      return this.publisherId;
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

   public void setVideoName(final String videoName) {
      this.videoName = videoName;
   }

   public void setDuringSec(final Integer duringSec) {
      this.duringSec = duringSec;
   }

   public void setVideoStatus(final String videoStatus) {
      this.videoStatus = videoStatus;
   }

   public void setVideoSize(final Long videoSize) {
      this.videoSize = videoSize;
   }

   public void setVideoUrl(final String videoUrl) {
      this.videoUrl = videoUrl;
   }

   public void setVideoSourceId(final String videoSourceId) {
      this.videoSourceId = videoSourceId;
   }

   public void setVersionId(final Long versionId) {
      this.versionId = versionId;
   }

   public void setChapterId(final Long chapterId) {
      this.chapterId = chapterId;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setPublisherId(final Long publisherId) {
      this.publisherId = publisherId;
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
      } else if (!(o instanceof VideoInfo)) {
         return false;
      } else {
         VideoInfo other = (VideoInfo)o;
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

            Object this$videoName = this.getVideoName();
            Object other$videoName = other.getVideoName();
            if (this$videoName == null) {
               if (other$videoName != null) {
                  return false;
               }
            } else if (!this$videoName.equals(other$videoName)) {
               return false;
            }

            Object this$duringSec = this.getDuringSec();
            Object other$duringSec = other.getDuringSec();
            if (this$duringSec == null) {
               if (other$duringSec != null) {
                  return false;
               }
            } else if (!this$duringSec.equals(other$duringSec)) {
               return false;
            }

            Object this$videoStatus = this.getVideoStatus();
            Object other$videoStatus = other.getVideoStatus();
            if (this$videoStatus == null) {
               if (other$videoStatus != null) {
                  return false;
               }
            } else if (!this$videoStatus.equals(other$videoStatus)) {
               return false;
            }

            Object this$videoSize = this.getVideoSize();
            Object other$videoSize = other.getVideoSize();
            if (this$videoSize == null) {
               if (other$videoSize != null) {
                  return false;
               }
            } else if (!this$videoSize.equals(other$videoSize)) {
               return false;
            }

            Object this$videoUrl = this.getVideoUrl();
            Object other$videoUrl = other.getVideoUrl();
            if (this$videoUrl == null) {
               if (other$videoUrl != null) {
                  return false;
               }
            } else if (!this$videoUrl.equals(other$videoUrl)) {
               return false;
            }

            Object this$videoSourceId = this.getVideoSourceId();
            Object other$videoSourceId = other.getVideoSourceId();
            if (this$videoSourceId == null) {
               if (other$videoSourceId != null) {
                  return false;
               }
            } else if (!this$videoSourceId.equals(other$videoSourceId)) {
               return false;
            }

            Object this$versionId = this.getVersionId();
            Object other$versionId = other.getVersionId();
            if (this$versionId == null) {
               if (other$versionId != null) {
                  return false;
               }
            } else if (!this$versionId.equals(other$versionId)) {
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

            Object this$courseId = this.getCourseId();
            Object other$courseId = other.getCourseId();
            if (this$courseId == null) {
               if (other$courseId != null) {
                  return false;
               }
            } else if (!this$courseId.equals(other$courseId)) {
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
      return other instanceof VideoInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $videoName = this.getVideoName();
      result = result * 59 + ($videoName == null ? 43 : $videoName.hashCode());
      Object $duringSec = this.getDuringSec();
      result = result * 59 + ($duringSec == null ? 43 : $duringSec.hashCode());
      Object $videoStatus = this.getVideoStatus();
      result = result * 59 + ($videoStatus == null ? 43 : $videoStatus.hashCode());
      Object $videoSize = this.getVideoSize();
      result = result * 59 + ($videoSize == null ? 43 : $videoSize.hashCode());
      Object $videoUrl = this.getVideoUrl();
      result = result * 59 + ($videoUrl == null ? 43 : $videoUrl.hashCode());
      Object $videoSourceId = this.getVideoSourceId();
      result = result * 59 + ($videoSourceId == null ? 43 : $videoSourceId.hashCode());
      Object $versionId = this.getVersionId();
      result = result * 59 + ($versionId == null ? 43 : $versionId.hashCode());
      Object $chapterId = this.getChapterId();
      result = result * 59 + ($chapterId == null ? 43 : $chapterId.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      return result;
   }

   public String toString() {
      return "VideoInfo(id=" + this.getId() + ", videoName=" + this.getVideoName() + ", duringSec=" + this.getDuringSec() + ", videoStatus=" + this.getVideoStatus() + ", videoSize=" + this.getVideoSize() + ", videoUrl=" + this.getVideoUrl() + ", videoSourceId=" + this.getVideoSourceId() + ", versionId=" + this.getVersionId() + ", chapterId=" + this.getChapterId() + ", courseId=" + this.getCourseId() + ", publisherId=" + this.getPublisherId() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", deleted=" + this.getDeleted() + ")";
   }
}
