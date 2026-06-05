package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class BaseCategoryInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String categoryName;
   private Date createTime;
   private Date updateTime;
   private String deleted;

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCategoryName() {
      return this.categoryName;
   }

   public void setCategoryName(String categoryName) {
      this.categoryName = categoryName;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   public Date getUpdateTime() {
      return this.updateTime;
   }

   public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
   }

   public String getDeleted() {
      return this.deleted;
   }

   public void setDeleted(String deleted) {
      this.deleted = deleted;
   }

   public String toString() {
      return "BaseCategoryInfo{id=" + this.id + ", categoryName=" + this.categoryName + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + "}";
   }
}
