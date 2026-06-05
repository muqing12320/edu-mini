package com.zhangsan.edu.mock.log;

import com.zhangsan.edu.mock.config.AppConfig;
import com.zhangsan.edu.mock.util.RanOpt;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;

public class AppCommon {
   private String mid;
   private String uid;
   private String sid;
   private String vc;
   private String ch;
   private String os;
   private String ar;
   private String md;
   private String ba;
   private String is_new;
   private String sc;

   public static AppCommon build() {
      String sid = null;
      String mid = "mid_" + RandomNum.getRandInt(1, AppConfig.max_mid) + "";
      String ar = (new RandomBox(new RanOpt[]{new RanOpt("1", 30), new RanOpt("2", 20), new RanOpt("3", 10), new RanOpt("4", 10), new RanOpt("5", 5), new RanOpt("6", 20), new RanOpt("7", 5), new RanOpt("8", 5)})).getRandStringValue();
      String md = (new RandomBox(new RanOpt[]{new RanOpt("Xiaomi 9", 30), new RanOpt("Xiaomi 10 Pro ", 30), new RanOpt("Xiaomi Mix2 ", 30), new RanOpt("iPhone X", 20), new RanOpt("iPhone 8", 20), new RanOpt("iPhone Xs", 20), new RanOpt("iPhone Xs Max", 20), new RanOpt("Huawei P30", 10), new RanOpt("Huawei Mate 30", 10), new RanOpt("Redmi k30", 10), new RanOpt("Honor 20s", 5), new RanOpt("vivo iqoo3", 20), new RanOpt("Oneplus 7", 5), new RanOpt("Sumsung Galaxy S20", 3)})).getRandStringValue();
      String ba = md.split(" ")[0];
      String ch;
      String os;
      if (ba.equals("iPhone")) {
         ch = "Appstore";
         os = "iOS " + (new RandomBox(new RanOpt[]{new RanOpt("13.3.1", 30), new RanOpt("13.2.9", 10), new RanOpt("13.2.3", 10), new RanOpt("12.4.1", 5)})).getRandStringValue();
      } else {
         ch = (new RandomBox(new RanOpt[]{new RanOpt("xiaomi", 30), new RanOpt("wandoujia", 10), new RanOpt("web", 10), new RanOpt("huawei", 5), new RanOpt("oppo", 20), new RanOpt("vivo", 5), new RanOpt("360", 5)})).getRandStringValue();
         os = "Android " + (new RandomBox(new RanOpt[]{new RanOpt("11.0", 70), new RanOpt("10.0", 20), new RanOpt("9.0", 5), new RanOpt("8.1", 5)})).getRandStringValue();
      }

      String vc = "v" + (new RandomBox(new RanOpt[]{new RanOpt("2.1.134", 70), new RanOpt("2.1.132", 20), new RanOpt("2.1.111", 5), new RanOpt("2.0.1", 5)})).getRandStringValue();
      String sc = "" + (new RandomBox(new RanOpt[]{new RanOpt("1", 70), new RanOpt("2", 20), new RanOpt("3", 5), new RanOpt("4", 5)})).getRandStringValue();
      String uid = RandomNum.getRandInt(1, AppConfig.max_uid) + "";
      String isnew = RandomNum.getRandInt(0, 1) + "";
      AppCommon appBase = new AppCommon(mid, uid, sid, vc, ch, os, ar, md, ba, isnew, sc);
      return appBase;
   }

   public static Builder builder() {
      return new Builder();
   }

   public String getMid() {
      return this.mid;
   }

   public String getUid() {
      return this.uid;
   }

   public String getSid() {
      return this.sid;
   }

   public String getVc() {
      return this.vc;
   }

   public String getCh() {
      return this.ch;
   }

   public String getOs() {
      return this.os;
   }

   public String getAr() {
      return this.ar;
   }

   public String getMd() {
      return this.md;
   }

   public String getBa() {
      return this.ba;
   }

   public String getIs_new() {
      return this.is_new;
   }

   public String getSc() {
      return this.sc;
   }

   public void setMid(final String mid) {
      this.mid = mid;
   }

   public void setUid(final String uid) {
      this.uid = uid;
   }

   public void setSid(final String sid) {
      this.sid = sid;
   }

   public void setVc(final String vc) {
      this.vc = vc;
   }

   public void setCh(final String ch) {
      this.ch = ch;
   }

   public void setOs(final String os) {
      this.os = os;
   }

   public void setAr(final String ar) {
      this.ar = ar;
   }

   public void setMd(final String md) {
      this.md = md;
   }

   public void setBa(final String ba) {
      this.ba = ba;
   }

   public void setIs_new(final String is_new) {
      this.is_new = is_new;
   }

   public void setSc(final String sc) {
      this.sc = sc;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppCommon)) {
         return false;
      } else {
         AppCommon other = (AppCommon)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$mid = this.getMid();
            Object other$mid = other.getMid();
            if (this$mid == null) {
               if (other$mid != null) {
                  return false;
               }
            } else if (!this$mid.equals(other$mid)) {
               return false;
            }

            Object this$uid = this.getUid();
            Object other$uid = other.getUid();
            if (this$uid == null) {
               if (other$uid != null) {
                  return false;
               }
            } else if (!this$uid.equals(other$uid)) {
               return false;
            }

            Object this$sid = this.getSid();
            Object other$sid = other.getSid();
            if (this$sid == null) {
               if (other$sid != null) {
                  return false;
               }
            } else if (!this$sid.equals(other$sid)) {
               return false;
            }

            Object this$vc = this.getVc();
            Object other$vc = other.getVc();
            if (this$vc == null) {
               if (other$vc != null) {
                  return false;
               }
            } else if (!this$vc.equals(other$vc)) {
               return false;
            }

            Object this$ch = this.getCh();
            Object other$ch = other.getCh();
            if (this$ch == null) {
               if (other$ch != null) {
                  return false;
               }
            } else if (!this$ch.equals(other$ch)) {
               return false;
            }

            Object this$os = this.getOs();
            Object other$os = other.getOs();
            if (this$os == null) {
               if (other$os != null) {
                  return false;
               }
            } else if (!this$os.equals(other$os)) {
               return false;
            }

            Object this$ar = this.getAr();
            Object other$ar = other.getAr();
            if (this$ar == null) {
               if (other$ar != null) {
                  return false;
               }
            } else if (!this$ar.equals(other$ar)) {
               return false;
            }

            Object this$md = this.getMd();
            Object other$md = other.getMd();
            if (this$md == null) {
               if (other$md != null) {
                  return false;
               }
            } else if (!this$md.equals(other$md)) {
               return false;
            }

            Object this$ba = this.getBa();
            Object other$ba = other.getBa();
            if (this$ba == null) {
               if (other$ba != null) {
                  return false;
               }
            } else if (!this$ba.equals(other$ba)) {
               return false;
            }

            Object this$is_new = this.getIs_new();
            Object other$is_new = other.getIs_new();
            if (this$is_new == null) {
               if (other$is_new != null) {
                  return false;
               }
            } else if (!this$is_new.equals(other$is_new)) {
               return false;
            }

            Object this$sc = this.getSc();
            Object other$sc = other.getSc();
            if (this$sc == null) {
               if (other$sc != null) {
                  return false;
               }
            } else if (!this$sc.equals(other$sc)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppCommon;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $uid = this.getUid();
      result = result * 59 + ($uid == null ? 43 : $uid.hashCode());
      Object $sid = this.getSid();
      result = result * 59 + ($sid == null ? 43 : $sid.hashCode());
      Object $vc = this.getVc();
      result = result * 59 + ($vc == null ? 43 : $vc.hashCode());
      Object $ch = this.getCh();
      result = result * 59 + ($ch == null ? 43 : $ch.hashCode());
      Object $os = this.getOs();
      result = result * 59 + ($os == null ? 43 : $os.hashCode());
      Object $ar = this.getAr();
      result = result * 59 + ($ar == null ? 43 : $ar.hashCode());
      Object $md = this.getMd();
      result = result * 59 + ($md == null ? 43 : $md.hashCode());
      Object $ba = this.getBa();
      result = result * 59 + ($ba == null ? 43 : $ba.hashCode());
      Object $is_new = this.getIs_new();
      result = result * 59 + ($is_new == null ? 43 : $is_new.hashCode());
      Object $sc = this.getSc();
      result = result * 59 + ($sc == null ? 43 : $sc.hashCode());
      return result;
   }

   public String toString() {
      return "AppCommon(mid=" + this.getMid() + ", uid=" + this.getUid() + ", sid=" + this.getSid() + ", vc=" + this.getVc() + ", ch=" + this.getCh() + ", os=" + this.getOs() + ", ar=" + this.getAr() + ", md=" + this.getMd() + ", ba=" + this.getBa() + ", is_new=" + this.getIs_new() + ", sc=" + this.getSc() + ")";
   }

   public AppCommon(final String mid, final String uid, final String sid, final String vc, final String ch, final String os, final String ar, final String md, final String ba, final String is_new, final String sc) {
      this.mid = mid;
      this.uid = uid;
      this.sid = sid;
      this.vc = vc;
      this.ch = ch;
      this.os = os;
      this.ar = ar;
      this.md = md;
      this.ba = ba;
      this.is_new = is_new;
      this.sc = sc;
   }

   public static class Builder {
      private String mid;
      private String uid;
      private String sid;
      private String vc;
      private String ch;
      private String os;
      private String ar;
      private String md;
      private String ba;
      private String is_new;
      private String sc;

      Builder() {
      }

      public Builder mid(final String mid) {
         this.mid = mid;
         return this;
      }

      public Builder uid(final String uid) {
         this.uid = uid;
         return this;
      }

      public Builder sid(final String sid) {
         this.sid = sid;
         return this;
      }

      public Builder vc(final String vc) {
         this.vc = vc;
         return this;
      }

      public Builder ch(final String ch) {
         this.ch = ch;
         return this;
      }

      public Builder os(final String os) {
         this.os = os;
         return this;
      }

      public Builder ar(final String ar) {
         this.ar = ar;
         return this;
      }

      public Builder md(final String md) {
         this.md = md;
         return this;
      }

      public Builder ba(final String ba) {
         this.ba = ba;
         return this;
      }

      public Builder is_new(final String is_new) {
         this.is_new = is_new;
         return this;
      }

      public Builder sc(final String sc) {
         this.sc = sc;
         return this;
      }

      public AppCommon build() {
         return new AppCommon(this.mid, this.uid, this.sid, this.vc, this.ch, this.os, this.ar, this.md, this.ba, this.is_new, this.sc);
      }

      public String toString() {
         return "AppCommon.Builder(mid=" + this.mid + ", uid=" + this.uid + ", sid=" + this.sid + ", vc=" + this.vc + ", ch=" + this.ch + ", os=" + this.os + ", ar=" + this.ar + ", md=" + this.md + ", ba=" + this.ba + ", is_new=" + this.is_new + ", sc=" + this.sc + ")";
      }
   }
}
