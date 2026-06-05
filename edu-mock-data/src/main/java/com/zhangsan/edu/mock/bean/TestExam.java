package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TestExam implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private Long paperId;
   private Long userId;
   private BigDecimal score;
   private Integer durationSec;
   private Date createTime;
   private Date submitTime;
   private Date updateTime;
   private String deleted;
   @TableField(
      exist = false
   )
   private List<TestExamQuestion> testExamQuestionList;

   public String toString() {
      return "TestExam{id=" + this.id + ", paperId=" + this.paperId + ", userId=" + this.userId + ", score=" + this.score + ", durationSec=" + this.durationSec + ", createTime=" + this.createTime + ", submitTime=" + this.submitTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaperId() {
      return this.paperId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getScore() {
      return this.score;
   }

   public Integer getDurationSec() {
      return this.durationSec;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getSubmitTime() {
      return this.submitTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public List<TestExamQuestion> getTestExamQuestionList() {
      return this.testExamQuestionList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaperId(final Long paperId) {
      this.paperId = paperId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setScore(final BigDecimal score) {
      this.score = score;
   }

   public void setDurationSec(final Integer durationSec) {
      this.durationSec = durationSec;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setSubmitTime(final Date submitTime) {
      this.submitTime = submitTime;
   }

   public void setUpdateTime(final Date updateTime) {
      this.updateTime = updateTime;
   }

   public void setDeleted(final String deleted) {
      this.deleted = deleted;
   }

   public void setTestExamQuestionList(final List<TestExamQuestion> testExamQuestionList) {
      this.testExamQuestionList = testExamQuestionList;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TestExam)) {
         return false;
      } else {
         TestExam other = (TestExam)o;
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

            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null) {
               if (other$userId != null) {
                  return false;
               }
            } else if (!this$userId.equals(other$userId)) {
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

            Object this$durationSec = this.getDurationSec();
            Object other$durationSec = other.getDurationSec();
            if (this$durationSec == null) {
               if (other$durationSec != null) {
                  return false;
               }
            } else if (!this$durationSec.equals(other$durationSec)) {
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

            Object this$submitTime = this.getSubmitTime();
            Object other$submitTime = other.getSubmitTime();
            if (this$submitTime == null) {
               if (other$submitTime != null) {
                  return false;
               }
            } else if (!this$submitTime.equals(other$submitTime)) {
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

            Object this$testExamQuestionList = this.getTestExamQuestionList();
            Object other$testExamQuestionList = other.getTestExamQuestionList();
            if (this$testExamQuestionList == null) {
               if (other$testExamQuestionList != null) {
                  return false;
               }
            } else if (!this$testExamQuestionList.equals(other$testExamQuestionList)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TestExam;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paperId = this.getPaperId();
      result = result * 59 + ($paperId == null ? 43 : $paperId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $durationSec = this.getDurationSec();
      result = result * 59 + ($durationSec == null ? 43 : $durationSec.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $submitTime = this.getSubmitTime();
      result = result * 59 + ($submitTime == null ? 43 : $submitTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      Object $testExamQuestionList = this.getTestExamQuestionList();
      result = result * 59 + ($testExamQuestionList == null ? 43 : $testExamQuestionList.hashCode());
      return result;
   }
}
