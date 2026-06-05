package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class TestQuestionOption implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String optionTxt;
   private Long questionId;
   private String isCorrect;
   private Date createTime;
   private Date updateTime;
   private String deleted;

   public String toString() {
      return "TestQuestionOption{id=" + this.id + ", optionTxt=" + this.optionTxt + ", questionId=" + this.questionId + ", isCorrect=" + this.isCorrect + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getOptionTxt() {
      return this.optionTxt;
   }

   public Long getQuestionId() {
      return this.questionId;
   }

   public String getIsCorrect() {
      return this.isCorrect;
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

   public void setOptionTxt(final String optionTxt) {
      this.optionTxt = optionTxt;
   }

   public void setQuestionId(final Long questionId) {
      this.questionId = questionId;
   }

   public void setIsCorrect(final String isCorrect) {
      this.isCorrect = isCorrect;
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
      } else if (!(o instanceof TestQuestionOption)) {
         return false;
      } else {
         TestQuestionOption other = (TestQuestionOption)o;
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

            Object this$optionTxt = this.getOptionTxt();
            Object other$optionTxt = other.getOptionTxt();
            if (this$optionTxt == null) {
               if (other$optionTxt != null) {
                  return false;
               }
            } else if (!this$optionTxt.equals(other$optionTxt)) {
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

            Object this$isCorrect = this.getIsCorrect();
            Object other$isCorrect = other.getIsCorrect();
            if (this$isCorrect == null) {
               if (other$isCorrect != null) {
                  return false;
               }
            } else if (!this$isCorrect.equals(other$isCorrect)) {
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
      return other instanceof TestQuestionOption;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $optionTxt = this.getOptionTxt();
      result = result * 59 + ($optionTxt == null ? 43 : $optionTxt.hashCode());
      Object $questionId = this.getQuestionId();
      result = result * 59 + ($questionId == null ? 43 : $questionId.hashCode());
      Object $isCorrect = this.getIsCorrect();
      result = result * 59 + ($isCorrect == null ? 43 : $isCorrect.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $deleted = this.getDeleted();
      result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode());
      return result;
   }
}
