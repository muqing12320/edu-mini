package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TestPaper implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String paperTitle;
   private Long courseId;
   private Date createTime;
   private Date updateTime;
   private Long publisherId;
   private String deleted;
   @TableField(
      exist = false
   )
   private List<TestQuestionInfo> testQuestionInfoList;

   public String toString() {
      return "TestPaper{id=" + this.id + ", paperTitle=" + this.paperTitle + ", courseId=" + this.courseId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", publisherId=" + this.publisherId + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getPaperTitle() {
      return this.paperTitle;
   }

   public Long getCourseId() {
      return this.courseId;
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

   public List<TestQuestionInfo> getTestQuestionInfoList() {
      return this.testQuestionInfoList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaperTitle(final String paperTitle) {
      this.paperTitle = paperTitle;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
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

   public void setTestQuestionInfoList(final List<TestQuestionInfo> testQuestionInfoList) {
      this.testQuestionInfoList = testQuestionInfoList;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestPaper)) {
         return false;
      } else {
         TestPaper other = (TestPaper)o;
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

            Object this$paperTitle = this.getPaperTitle();
            Object other$paperTitle = other.getPaperTitle();
            if (this$paperTitle == null) {
               if (other$paperTitle != null) {
                  return false;
               }
            } else if (!this$paperTitle.equals(other$paperTitle)) {
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

            Object this$testQuestionInfoList = this.getTestQuestionInfoList();
            Object other$testQuestionInfoList = other.getTestQuestionInfoList();
            if (this$testQuestionInfoList == null) {
               if (other$testQuestionInfoList != null) {
                  return false;
               }
            } else if (!this$testQuestionInfoList.equals(other$testQuestionInfoList)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestPaper;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paperTitle = this.getPaperTitle();
      result = result * 59 + ($paperTitle == null ? 43 : $paperTitle.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $testQuestionInfoList = this.getTestQuestionInfoList();
      result = result * 59 + ($testQuestionInfoList == null ? 43 : $testQuestionInfoList.hashCode());
      return result;
   }
}
