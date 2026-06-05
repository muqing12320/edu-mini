package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CourseInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String courseName;
   private String courseSlogan;
   private String courseCoverUrl;
   private Long subjectId;
   private String teacher;
   private Long publisherId;
   private Long chapterNum;
   private BigDecimal originPrice;
   private BigDecimal reduceAmount;
   private BigDecimal actualPrice;
   private String courseIntroduce;
   private Date createTime;
   private String deleted;
   private Date updateTime;
   @TableField(
      exist = false
   )
   private List<ChapterInfo> chapterInfoList;

   public String toString() {
      return "CourseInfo{id=" + this.id + ", courseName=" + this.courseName + ", courseSlogan=" + this.courseSlogan + ", courseCoverUrl=" + this.courseCoverUrl + ", subjectId=" + this.subjectId + ", teacher=" + this.teacher + ", publisherId=" + this.publisherId + ", chapterNum=" + this.chapterNum + ", originPrice=" + this.originPrice + ", reduceAmount=" + this.reduceAmount + ", actualPrice=" + this.actualPrice + ", courseIntroduce=" + this.courseIntroduce + ", createTime=" + this.createTime + ", deleted=" + this.deleted + ", updateTime=" + this.updateTime + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getCourseName() {
      return this.courseName;
   }

   public String getCourseSlogan() {
      return this.courseSlogan;
   }

   public String getCourseCoverUrl() {
      return this.courseCoverUrl;
   }

   public Long getSubjectId() {
      return this.subjectId;
   }

   public String getTeacher() {
      return this.teacher;
   }

   public Long getPublisherId() {
      return this.publisherId;
   }

   public Long getChapterNum() {
      return this.chapterNum;
   }

   public BigDecimal getOriginPrice() {
      return this.originPrice;
   }

   public BigDecimal getReduceAmount() {
      return this.reduceAmount;
   }

   public BigDecimal getActualPrice() {
      return this.actualPrice;
   }

   public String getCourseIntroduce() {
      return this.courseIntroduce;
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

   public List<ChapterInfo> getChapterInfoList() {
      return this.chapterInfoList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCourseName(final String courseName) {
      this.courseName = courseName;
   }

   public void setCourseSlogan(final String courseSlogan) {
      this.courseSlogan = courseSlogan;
   }

   public void setCourseCoverUrl(final String courseCoverUrl) {
      this.courseCoverUrl = courseCoverUrl;
   }

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
   }

   public void setTeacher(final String teacher) {
      this.teacher = teacher;
   }

   public void setPublisherId(final Long publisherId) {
      this.publisherId = publisherId;
   }

   public void setChapterNum(final Long chapterNum) {
      this.chapterNum = chapterNum;
   }

   public void setOriginPrice(final BigDecimal originPrice) {
      this.originPrice = originPrice;
   }

   public void setReduceAmount(final BigDecimal reduceAmount) {
      this.reduceAmount = reduceAmount;
   }

   public void setActualPrice(final BigDecimal actualPrice) {
      this.actualPrice = actualPrice;
   }

   public void setCourseIntroduce(final String courseIntroduce) {
      this.courseIntroduce = courseIntroduce;
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

   public void setChapterInfoList(final List<ChapterInfo> chapterInfoList) {
      this.chapterInfoList = chapterInfoList;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CourseInfo)) {
         return false;
      } else {
         CourseInfo other = (CourseInfo)o;
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

            Object this$courseName = this.getCourseName();
            Object other$courseName = other.getCourseName();
            if (this$courseName == null) {
               if (other$courseName != null) {
                  return false;
               }
            } else if (!this$courseName.equals(other$courseName)) {
               return false;
            }

            Object this$courseSlogan = this.getCourseSlogan();
            Object other$courseSlogan = other.getCourseSlogan();
            if (this$courseSlogan == null) {
               if (other$courseSlogan != null) {
                  return false;
               }
            } else if (!this$courseSlogan.equals(other$courseSlogan)) {
               return false;
            }

            Object this$courseCoverUrl = this.getCourseCoverUrl();
            Object other$courseCoverUrl = other.getCourseCoverUrl();
            if (this$courseCoverUrl == null) {
               if (other$courseCoverUrl != null) {
                  return false;
               }
            } else if (!this$courseCoverUrl.equals(other$courseCoverUrl)) {
               return false;
            }

            Object this$subjectId = this.getSubjectId();
            Object other$subjectId = other.getSubjectId();
            if (this$subjectId == null) {
               if (other$subjectId != null) {
                  return false;
               }
            } else if (!this$subjectId.equals(other$subjectId)) {
               return false;
            }

            Object this$teacher = this.getTeacher();
            Object other$teacher = other.getTeacher();
            if (this$teacher == null) {
               if (other$teacher != null) {
                  return false;
               }
            } else if (!this$teacher.equals(other$teacher)) {
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

            Object this$chapterNum = this.getChapterNum();
            Object other$chapterNum = other.getChapterNum();
            if (this$chapterNum == null) {
               if (other$chapterNum != null) {
                  return false;
               }
            } else if (!this$chapterNum.equals(other$chapterNum)) {
               return false;
            }

            Object this$originPrice = this.getOriginPrice();
            Object other$originPrice = other.getOriginPrice();
            if (this$originPrice == null) {
               if (other$originPrice != null) {
                  return false;
               }
            } else if (!this$originPrice.equals(other$originPrice)) {
               return false;
            }

            Object this$reduceAmount = this.getReduceAmount();
            Object other$reduceAmount = other.getReduceAmount();
            if (this$reduceAmount == null) {
               if (other$reduceAmount != null) {
                  return false;
               }
            } else if (!this$reduceAmount.equals(other$reduceAmount)) {
               return false;
            }

            Object this$actualPrice = this.getActualPrice();
            Object other$actualPrice = other.getActualPrice();
            if (this$actualPrice == null) {
               if (other$actualPrice != null) {
                  return false;
               }
            } else if (!this$actualPrice.equals(other$actualPrice)) {
               return false;
            }

            Object this$courseIntroduce = this.getCourseIntroduce();
            Object other$courseIntroduce = other.getCourseIntroduce();
            if (this$courseIntroduce == null) {
               if (other$courseIntroduce != null) {
                  return false;
               }
            } else if (!this$courseIntroduce.equals(other$courseIntroduce)) {
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

            Object this$chapterInfoList = this.getChapterInfoList();
            Object other$chapterInfoList = other.getChapterInfoList();
            if (this$chapterInfoList == null) {
               if (other$chapterInfoList != null) {
                  return false;
               }
            } else if (!this$chapterInfoList.equals(other$chapterInfoList)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CourseInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $courseName = this.getCourseName();
      result = result * 59 + ($courseName == null ? 43 : $courseName.hashCode());
      Object $courseSlogan = this.getCourseSlogan();
      result = result * 59 + ($courseSlogan == null ? 43 : $courseSlogan.hashCode());
      Object $courseCoverUrl = this.getCourseCoverUrl();
      result = result * 59 + ($courseCoverUrl == null ? 43 : $courseCoverUrl.hashCode());
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $teacher = this.getTeacher();
      result = result * 59 + ($teacher == null ? 43 : $teacher.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $chapterNum = this.getChapterNum();
      result = result * 59 + ($chapterNum == null ? 43 : $chapterNum.hashCode());
      Object $originPrice = this.getOriginPrice();
      result = result * 59 + ($originPrice == null ? 43 : $originPrice.hashCode());
      Object $reduceAmount = this.getReduceAmount();
      result = result * 59 + ($reduceAmount == null ? 43 : $reduceAmount.hashCode());
      Object $actualPrice = this.getActualPrice();
      result = result * 59 + ($actualPrice == null ? 43 : $actualPrice.hashCode());
      Object $courseIntroduce = this.getCourseIntroduce();
      result = result * 59 + ($courseIntroduce == null ? 43 : $courseIntroduce.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $chapterInfoList = this.getChapterInfoList();
      result = result * 59 + ($chapterInfoList == null ? 43 : $chapterInfoList.hashCode());
      return result;
   }
}
