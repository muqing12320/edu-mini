package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TestExamQuestion implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long examId;
   private Long paperId;
   private Long questionId;
   private Long userId;
   private String answer;
   private Date createTime;
   private Date updateTime;
   private String deleted;
   private BigDecimal score;
   private String isCorrect;

   public String toString() {
      return "TestExamQuestion{id=" + this.id + ", paperId=" + this.paperId + ", questionId=" + this.questionId + ", userId=" + this.userId + ", answer=" + this.answer + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getExamId() {
      return this.examId;
   }

   public Long getPaperId() {
      return this.paperId;
   }

   public Long getQuestionId() {
      return this.questionId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getAnswer() {
      return this.answer;
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

   public BigDecimal getScore() {
      return this.score;
   }

   public String getIsCorrect() {
      return this.isCorrect;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setExamId(final Long examId) {
      this.examId = examId;
   }

   public void setPaperId(final Long paperId) {
      this.paperId = paperId;
   }

   public void setQuestionId(final Long questionId) {
      this.questionId = questionId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setAnswer(final String answer) {
      this.answer = answer;
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

   public void setScore(final BigDecimal score) {
      this.score = score;
   }

   public void setIsCorrect(final String isCorrect) {
      this.isCorrect = isCorrect;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestExamQuestion)) {
         return false;
      } else {
         TestExamQuestion other = (TestExamQuestion)o;
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

            Object this$examId = this.getExamId();
            Object other$examId = other.getExamId();
            if (this$examId == null) {
               if (other$examId != null) {
                  return false;
               }
            } else if (!this$examId.equals(other$examId)) {
               return false;
            }

            Object this$paperId = this.getPaperId();
            Object other$paperId = other.getPaperId();
            if (this$paperId == null) {
               if (other$paperId != null) {
                  return false;
               }
            } else if (!this$paperId.equals(other$paperId)) {
               return false;
            }

            Object this$questionId = this.getQuestionId();
            Object other$questionId = other.getQuestionId();
            if (this$questionId == null) {
               if (other$questionId != null) {
                  return false;
               }
            } else if (!this$questionId.equals(other$questionId)) {
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

            Object this$answer = this.getAnswer();
            Object other$answer = other.getAnswer();
            if (this$answer == null) {
               if (other$answer != null) {
                  return false;
               }
            } else if (!this$answer.equals(other$answer)) {
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

            Object this$score = this.getScore();
            Object other$score = other.getScore();
            if (this$score == null) {
               if (other$score != null) {
                  return false;
               }
            } else if (!this$score.equals(other$score)) {
               return false;
            }

            Object this$isCorrect = this.getIsCorrect();
            Object other$isCorrect = other.getIsCorrect();
            if (this$isCorrect == null) {
               if (other$isCorrect != null) {
                  return false;
               }
            } else if (!this$isCorrect.equals(other$isCorrect)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestExamQuestion;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $examId = this.getExamId();
      result = result * 59 + ($examId == null ? 43 : $examId.hashCode());
      Object $paperId = this.getPaperId();
      result = result * 59 + ($paperId == null ? 43 : $paperId.hashCode());
      Object $questionId = this.getQuestionId();
      result = result * 59 + ($questionId == null ? 43 : $questionId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $answer = this.getAnswer();
      result = result * 59 + ($answer == null ? 43 : $answer.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $isCorrect = this.getIsCorrect();
      result = result * 59 + ($isCorrect == null ? 43 : $isCorrect.hashCode());
      return result;
   }
}
