package com.zhangsan.edu.mock.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

public class BaseProvince implements Serializable {
   private static final long serialVersionUID = 1L;
   private Long id;
   private String name;
   private String regionId;
   private String areaCode;
   private String isoCode;
   @TableField("iso_3166_2")
   private String iso31662;

   public String toString() {
      return "BaseProvince{id=" + this.id + ", name=" + this.name + ", regionId=" + this.regionId + ", areaCode=" + this.areaCode + ", isoCode=" + this.isoCode + ", iso31662=" + this.iso31662 + "}";
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getRegionId() {
      return this.regionId;
   }

   public String getAreaCode() {
      return this.areaCode;
   }

   public String getIsoCode() {
      return this.isoCode;
   }

   public String getIso31662() {
      return this.iso31662;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRegionId(final String regionId) {
      this.regionId = regionId;
   }

   public void setAreaCode(final String areaCode) {
      this.areaCode = areaCode;
   }

   public void setIsoCode(final String isoCode) {
      this.isoCode = isoCode;
   }

   public void setIso31662(final String iso31662) {
      this.iso31662 = iso31662;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BaseProvince)) {
         return false;
      } else {
         BaseProvince other = (BaseProvince)o;
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

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
               if (other$name != null) {
                  return false;
               }
            } else if (!this$name.equals(other$name)) {
               return false;
            }

            Object this$regionId = this.getRegionId();
            Object other$regionId = other.getRegionId();
            if (this$regionId == null) {
               if (other$regionId != null) {
                  return false;
               }
            } else if (!this$regionId.equals(other$regionId)) {
               return false;
            }

            Object this$areaCode = this.getAreaCode();
            Object other$areaCode = other.getAreaCode();
            if (this$areaCode == null) {
               if (other$areaCode != null) {
                  return false;
               }
            } else if (!this$areaCode.equals(other$areaCode)) {
               return false;
            }

            Object this$isoCode = this.getIsoCode();
            Object other$isoCode = other.getIsoCode();
            if (this$isoCode == null) {
               if (other$isoCode != null) {
                  return false;
               }
            } else if (!this$isoCode.equals(other$isoCode)) {
               return false;
            }

            Object this$iso31662 = this.getIso31662();
            Object other$iso31662 = other.getIso31662();
            if (this$iso31662 == null) {
               if (other$iso31662 != null) {
                  return false;
               }
            } else if (!this$iso31662.equals(other$iso31662)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BaseProvince;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $areaCode = this.getAreaCode();
      result = result * 59 + ($areaCode == null ? 43 : $areaCode.hashCode());
      Object $isoCode = this.getIsoCode();
      result = result * 59 + ($isoCode == null ? 43 : $isoCode.hashCode());
      Object $iso31662 = this.getIso31662();
      result = result * 59 + ($iso31662 == null ? 43 : $iso31662.hashCode());
      return result;
   }
}
