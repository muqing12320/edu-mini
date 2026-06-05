package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TestQuestionInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String questionTxt;
   private Long chapterId;
   private Long courseId;
   private Long questionType;
   private Date createTime;
   private Date updateTime;
   private Long publisherId;
   private String deleted;
   @TableField(
      exist = false
   )
   List<KnowledgePoint> knowledgePointList;
   @TableField(
      exist = false
   )
   List<TestQuestionOption> testQuestionOptionList;
   @TableField(
      exist = false
   )
   private BigDecimal score;

   public String toString() {
      return "TestQuestionInfo{id=" + this.id + ", questionTxt=" + this.questionTxt + ", chapterId=" + this.chapterId + ", courseId=" + this.courseId + ", questionType=" + this.questionType + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", publisherId=" + this.publisherId + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getQuestionTxt() {
      return this.questionTxt;
   }

   public Long getChapterId() {
      return this.chapterId;
   }

   public Long getCourseId() {
      return this.courseId;
   }

   public Long getQuestionType() {
      return this.questionType;
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

   public List<KnowledgePoint> getKnowledgePointList() {
      return this.knowledgePointList;
   }

   public List<TestQuestionOption> getTestQuestionOptionList() {
      return this.testQuestionOptionList;
   }

   public BigDecimal getScore() {
      return this.score;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuestionTxt(final String questionTxt) {
      this.questionTxt = questionTxt;
   }

   public void setChapterId(final Long chapterId) {
      this.chapterId = chapterId;
   }

   public void setCourseId(final Long courseId) {
      this.courseId = courseId;
   }

   public void setQuestionType(final Long questionType) {
      this.questionType = questionType;
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

   public void setKnowledgePointList(final List<KnowledgePoint> knowledgePointList) {
      this.knowledgePointList = knowledgePointList;
   }

   public void setTestQuestionOptionList(final List<TestQuestionOption> testQuestionOptionList) {
      this.testQuestionOptionList = testQuestionOptionList;
   }

   public void setScore(final BigDecimal score) {
      this.score = score;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestQuestionInfo)) {
         return false;
      } else {
         TestQuestionInfo other = (TestQuestionInfo)o;
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

            Object this$questionTxt = this.getQuestionTxt();
            Object other$questionTxt = other.getQuestionTxt();
            if (this$questionTxt == null) {
               if (other$questionTxt != null) {
                  return false;
               }
            } else if (!this$questionTxt.equals(other$questionTxt)) {
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

            Object this$questionType = this.getQuestionType();
            Object other$questionType = other.getQuestionType();
            if (this$questionType == null) {
               if (other$questionType != null) {
                  return false;
               }
            } else if (!this$questionType.equals(other$questionType)) {
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

            Object this$knowledgePointList = this.getKnowledgePointList();
            Object other$knowledgePointList = other.getKnowledgePointList();
            if (this$knowledgePointList == null) {
               if (other$knowledgePointList != null) {
                  return false;
               }
            } else if (!this$knowledgePointList.equals(other$knowledgePointList)) {
               return false;
            }

            Object this$testQuestionOptionList = this.getTestQuestionOptionList();
            Object other$testQuestionOptionList = other.getTestQuestionOptionList();
            if (this$testQuestionOptionList == null) {
               if (other$testQuestionOptionList != null) {
                  return false;
               }
            } else if (!this$testQuestionOptionList.equals(other$testQuestionOptionList)) {
               return false;
            }

            Object this$score = this.getScore();
            Object other$score = other.getScore();
            if (this$score == null) {
               if (other$score != null) {
                  return false;
               }
            } else if (!this$score.equals(other$score)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestQuestionInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $questionTxt = this.getQuestionTxt();
      result = result * 59 + ($questionTxt == null ? 43 : $questionTxt.hashCode());
      Object $chapterId = this.getChapterId();
      result = result * 59 + ($chapterId == null ? 43 : $chapterId.hashCode());
      Object $courseId = this.getCourseId();
      result = result * 59 + ($courseId == null ? 43 : $courseId.hashCode());
      Object $questionType = this.getQuestionType();
      result = result * 59 + ($questionType == null ? 43 : $questionType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $knowledgePointList = this.getKnowledgePointList();
      result = result * 59 + ($knowledgePointList == null ? 43 : $knowledgePointList.hashCode());
      Object $testQuestionOptionList = this.getTestQuestionOptionList();
      result = result * 59 + ($testQuestionOptionList == null ? 43 : $testQuestionOptionList.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      return result;
   }
}
