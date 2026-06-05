package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
   private static final long serialVersionUID = 1L;
   @TableId(
      value = "id",
      type = IdType.AUTO
   )
   private Long id;
   private String loginName;
   private String nickName;
   private String passwd;
   private String realName;
   private String phoneNum;
   private String email;
   private String headImg;
   private String userLevel;
   private Date birthday;
   private String gender;
   private Date createTime;
   private Date operateTime;

   public Long getId() {
      return this.id;
   }

   public String getLoginName() {
      return this.loginName;
   }

   public String getNickName() {
      return this.nickName;
   }

   public String getPasswd() {
      return this.passwd;
   }

   public String getRealName() {
      return this.realName;
   }

   public String getPhoneNum() {
      return this.phoneNum;
   }

   public String getEmail() {
      return this.email;
   }

   public String getHeadImg() {
      return this.headImg;
   }

   public String getUserLevel() {
      return this.userLevel;
   }

   public Date getBirthday() {
      return this.birthday;
   }

   public String getGender() {
      return this.gender;
   }

   public Date getCreateTime() {
      return this.createTime;
   }

   public Date getOperateTime() {
      return this.operateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLoginName(final String loginName) {
      this.loginName = loginName;
   }

   public void setNickName(final String nickName) {
      this.nickName = nickName;
   }

   public void setPasswd(final String passwd) {
      this.passwd = passwd;
   }

   public void setRealName(final String realName) {
      this.realName = realName;
   }

   public void setPhoneNum(final String phoneNum) {
      this.phoneNum = phoneNum;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setHeadImg(final String headImg) {
      this.headImg = headImg;
   }

   public void setUserLevel(final String userLevel) {
      this.userLevel = userLevel;
   }

   public void setBirthday(final Date birthday) {
      this.birthday = birthday;
   }

   public void setGender(final String gender) {
      this.gender = gender;
   }

   public void setCreateTime(final Date createTime) {
      this.createTime = createTime;
   }

   public void setOperateTime(final Date operateTime) {
      this.operateTime = operateTime;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserInfo)) {
         return false;
      } else {
         UserInfo other = (UserInfo)o;
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

            Object this$loginName = this.getLoginName();
            Object other$loginName = other.getLoginName();
            if (this$loginName == null) {
               if (other$loginName != null) {
                  return false;
               }
            } else if (!this$loginName.equals(other$loginName)) {
               return false;
            }

            Object this$nickName = this.getNickName();
            Object other$nickName = other.getNickName();
            if (this$nickName == null) {
               if (other$nickName != null) {
                  return false;
               }
            } else if (!this$nickName.equals(other$nickName)) {
               return false;
            }

            Object this$passwd = this.getPasswd();
            Object other$passwd = other.getPasswd();
            if (this$passwd == null) {
               if (other$passwd != null) {
                  return false;
               }
            } else if (!this$passwd.equals(other$passwd)) {
               return false;
            }

            Object this$realName = this.getRealName();
            Object other$realName = other.getRealName();
            if (this$realName == null) {
               if (other$realName != null) {
                  return false;
               }
            } else if (!this$realName.equals(other$realName)) {
               return false;
            }

            Object this$phoneNum = this.getPhoneNum();
            Object other$phoneNum = other.getPhoneNum();
            if (this$phoneNum == null) {
               if (other$phoneNum != null) {
                  return false;
               }
            } else if (!this$phoneNum.equals(other$phoneNum)) {
               return false;
            }

            Object this$email = this.getEmail();
            Object other$email = other.getEmail();
            if (this$email == null) {
               if (other$email != null) {
                  return false;
               }
            } else if (!this$email.equals(other$email)) {
               return false;
            }

            Object this$headImg = this.getHeadImg();
            Object other$headImg = other.getHeadImg();
            if (this$headImg == null) {
               if (other$headImg != null) {
                  return false;
               }
            } else if (!this$headImg.equals(other$headImg)) {
               return false;
            }

            Object this$userLevel = this.getUserLevel();
            Object other$userLevel = other.getUserLevel();
            if (this$userLevel == null) {
               if (other$userLevel != null) {
                  return false;
               }
            } else if (!this$userLevel.equals(other$userLevel)) {
               return false;
            }

            Object this$birthday = this.getBirthday();
            Object other$birthday = other.getBirthday();
            if (this$birthday == null) {
               if (other$birthday != null) {
                  return false;
               }
            } else if (!this$birthday.equals(other$birthday)) {
               return false;
            }

            Object this$gender = this.getGender();
            Object other$gender = other.getGender();
            if (this$gender == null) {
               if (other$gender != null) {
                  return false;
               }
            } else if (!this$gender.equals(other$gender)) {
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

            Object this$operateTime = this.getOperateTime();
            Object other$operateTime = other.getOperateTime();
            if (this$operateTime == null) {
               if (other$operateTime != null) {
                  return false;
               }
            } else if (!this$operateTime.equals(other$operateTime)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserInfo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $loginName = this.getLoginName();
      result = result * 59 + ($loginName == null ? 43 : $loginName.hashCode());
      Object $nickName = this.getNickName();
      result = result * 59 + ($nickName == null ? 43 : $nickName.hashCode());
      Object $passwd = this.getPasswd();
      result = result * 59 + ($passwd == null ? 43 : $passwd.hashCode());
      Object $realName = this.getRealName();
      result = result * 59 + ($realName == null ? 43 : $realName.hashCode());
      Object $phoneNum = this.getPhoneNum();
      result = result * 59 + ($phoneNum == null ? 43 : $phoneNum.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $headImg = this.getHeadImg();
      result = result * 59 + ($headImg == null ? 43 : $headImg.hashCode());
      Object $userLevel = this.getUserLevel();
      result = result * 59 + ($userLevel == null ? 43 : $userLevel.hashCode());
      Object $birthday = this.getBirthday();
      result = result * 59 + ($birthday == null ? 43 : $birthday.hashCode());
      Object $gender = this.getGender();
      result = result * 59 + ($gender == null ? 43 : $gender.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $operateTime = this.getOperateTime();
      result = result * 59 + ($operateTime == null ? 43 : $operateTime.hashCode());
      return result;
   }

   public String toString() {
      return "UserInfo(id=" + this.getId() + ", loginName=" + this.getLoginName() + ", nickName=" + this.getNickName() + ", passwd=" + this.getPasswd() + ", realName=" + this.getRealName() + ", phoneNum=" + this.getPhoneNum() + ", email=" + this.getEmail() + ", headImg=" + this.getHeadImg() + ", userLevel=" + this.getUserLevel() + ", birthday=" + this.getBirthday() + ", gender=" + this.getGender() + ", createTime=" + this.getCreateTime() + ", operateTime=" + this.getOperateTime() + ")";
   }
}
