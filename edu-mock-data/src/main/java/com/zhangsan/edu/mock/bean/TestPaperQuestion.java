package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TestPaperQuestion implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long paperId;
   private Long questionId;
   private BigDecimal score;
   private Date createTime;
   private String deleted;
   private Long publisherId;

   public String toString() {
      return "TestPaperQuestion{id=" + this.id + ", paperId=" + this.paperId + ", questionId=" + this.questionId + ", score=" + this.score + ", createTime=" + this.createTime + ", deleted=" + this.deleted + ", publisherId=" + this.publisherId + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaperId() {
      return this.paperId;
   }

   public Long getQuestionId() {
      return this.questionId;
   }

   public BigDecimal getScore() {
      return this.score;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public Long getPublisherId() {
      return this.publisherId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaperId(final Long paperId) {
      this.paperId = paperId;
   }

   public void setQuestionId(final Long questionId) {
      this.questionId = questionId;
   }

   public void setScore(final BigDecimal score) {
      this.score = score;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public void setPublisherId(final Long publisherId) {
      this.publisherId = publisherId;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestPaperQuestion)) {
         return false;
      } else {
         TestPaperQuestion other = (TestPaperQuestion)o;
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

            Object this$score = this.getScore();
            Object other$score = other.getScore();
            if (this$score == null) {
               if (other$score != null) {
                  return false;
               }
            } else if (!this$score.equals(other$score)) {
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

            Object this$publisherId = this.getPublisherId();
            Object other$publisherId = other.getPublisherId();
            if (this$publisherId == null) {
               if (other$publisherId != null) {
                  return false;
               }
            } else if (!this$publisherId.equals(other$publisherId)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestPaperQuestion;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paperId = this.getPaperId();
      result = result * 59 + ($paperId == null ? 43 : $paperId.hashCode());
      Object $questionId = this.getQuestionId();
      result = result * 59 + ($questionId == null ? 43 : $questionId.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $publisherId = this.getPublisherId();
      result = result * 59 + ($publisherId == null ? 43 : $publisherId.hashCode());
      return result;
   }
}
