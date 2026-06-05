package com.zhangsan.edu.mock.log;

import com.zhangsan.edu.mock.util.RanOpt;
import com.zhangsan.edu.mock.util.RandomBox;
import com.zhangsan.edu.mock.util.RandomNum;

public class AppStart {
   private String entry;
   private Long open_ad_id;
   Integer open_ad_ms;
   private Integer open_ad_skip_ms;
   private Integer loading_time;
   private Integer first_open;

   private static String $default$entry() {
      return (new RandomBox(new RanOpt[]{new RanOpt("install", 5), new RanOpt("icon", 75), new RanOpt("notice", 20)})).getRandStringValue();
   }

   private static Long $default$open_ad_id() {
      return (long)RandomNum.getRandInt(1, 20) + 0L;
   }

   private static Integer $default$open_ad_ms() {
      return RandomNum.getRandInt(1000, 10000);
   }

   private static Integer $default$open_ad_skip_ms() {
      return RandomBox.builder().add(0, 50).add(RandomNum.getRandInt(1000, 100000), 50).build().getRandIntValue();
   }

   private static Integer $default$loading_time() {
      return RandomNum.getRandInt(1000, 20000);
   }

   private static Integer $default$first_open() {
      return RandomNum.getRandInt(0, 1);
   }

   public static AppStartBuilder builder() {
      return new AppStartBuilder();
   }

   public String getEntry() {
      return this.entry;
   }

   public Long getOpen_ad_id() {
      return this.open_ad_id;
   }

   public Integer getOpen_ad_ms() {
      return this.open_ad_ms;
   }

   public Integer getOpen_ad_skip_ms() {
      return this.open_ad_skip_ms;
   }

   public Integer getLoading_time() {
      return this.loading_time;
   }

   public Integer getFirst_open() {
      return this.first_open;
   }

   public void setEntry(final String entry) {
      this.entry = entry;
   }

   public void setOpen_ad_id(final Long open_ad_id) {
      this.open_ad_id = open_ad_id;
   }

   public void setOpen_ad_ms(final Integer open_ad_ms) {
      this.open_ad_ms = open_ad_ms;
   }

   public void setOpen_ad_skip_ms(final Integer open_ad_skip_ms) {
      this.open_ad_skip_ms = open_ad_skip_ms;
   }

   public void setLoading_time(final Integer loading_time) {
      this.loading_time = loading_time;
   }

   public void setFirst_open(final Integer first_open) {
      this.first_open = first_open;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppStart)) {
         return false;
      } else {
         AppStart other = (AppStart)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$entry = this.getEntry();
            Object other$entry = other.getEntry();
            if (this$entry == null) {
               if (other$entry != null) {
                  return false;
               }
            } else if (!this$entry.equals(other$entry)) {
               return false;
            }

            Object this$open_ad_id = this.getOpen_ad_id();
            Object other$open_ad_id = other.getOpen_ad_id();
            if (this$open_ad_id == null) {
               if (other$open_ad_id != null) {
                  return false;
               }
            } else if (!this$open_ad_id.equals(other$open_ad_id)) {
               return false;
            }

            Object this$open_ad_ms = this.getOpen_ad_ms();
            Object other$open_ad_ms = other.getOpen_ad_ms();
            if (this$open_ad_ms == null) {
               if (other$open_ad_ms != null) {
                  return false;
               }
            } else if (!this$open_ad_ms.equals(other$open_ad_ms)) {
               return false;
            }

            Object this$open_ad_skip_ms = this.getOpen_ad_skip_ms();
            Object other$open_ad_skip_ms = other.getOpen_ad_skip_ms();
            if (this$open_ad_skip_ms == null) {
               if (other$open_ad_skip_ms != null) {
                  return false;
               }
            } else if (!this$open_ad_skip_ms.equals(other$open_ad_skip_ms)) {
               return false;
            }

            Object this$loading_time = this.getLoading_time();
            Object other$loading_time = other.getLoading_time();
            if (this$loading_time == null) {
               if (other$loading_time != null) {
                  return false;
               }
            } else if (!this$loading_time.equals(other$loading_time)) {
               return false;
            }

            Object this$first_open = this.getFirst_open();
            Object other$first_open = other.getFirst_open();
            if (this$first_open == null) {
               if (other$first_open != null) {
                  return false;
               }
            } else if (!this$first_open.equals(other$first_open)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppStart;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entry = this.getEntry();
      result = result * 59 + ($entry == null ? 43 : $entry.hashCode());
      Object $open_ad_id = this.getOpen_ad_id();
      result = result * 59 + ($open_ad_id == null ? 43 : $open_ad_id.hashCode());
      Object $open_ad_ms = this.getOpen_ad_ms();
      result = result * 59 + ($open_ad_ms == null ? 43 : $open_ad_ms.hashCode());
      Object $open_ad_skip_ms = this.getOpen_ad_skip_ms();
      result = result * 59 + ($open_ad_skip_ms == null ? 43 : $open_ad_skip_ms.hashCode());
      Object $loading_time = this.getLoading_time();
      result = result * 59 + ($loading_time == null ? 43 : $loading_time.hashCode());
      Object $first_open = this.getFirst_open();
      result = result * 59 + ($first_open == null ? 43 : $first_open.hashCode());
      return result;
   }

   public String toString() {
      return "AppStart(entry=" + this.getEntry() + ", open_ad_id=" + this.getOpen_ad_id() + ", open_ad_ms=" + this.getOpen_ad_ms() + ", open_ad_skip_ms=" + this.getOpen_ad_skip_ms() + ", loading_time=" + this.getLoading_time() + ", first_open=" + this.getFirst_open() + ")";
   }

   public AppStart(final String entry, final Long open_ad_id, final Integer open_ad_ms, final Integer open_ad_skip_ms, final Integer loading_time, final Integer first_open) {
      this.entry = entry;
      this.open_ad_id = open_ad_id;
      this.open_ad_ms = open_ad_ms;
      this.open_ad_skip_ms = open_ad_skip_ms;
      this.loading_time = loading_time;
      this.first_open = first_open;
   }

   public AppStart() {
   }

   public static class AppStartBuilder {
      private boolean entry$set;
      private String entry;
      private boolean open_ad_id$set;
      private Long open_ad_id;
      private boolean open_ad_ms$set;
      private Integer open_ad_ms;
      private boolean open_ad_skip_ms$set;
      private Integer open_ad_skip_ms;
      private boolean loading_time$set;
      private Integer loading_time;
      private boolean first_open$set;
      private Integer first_open;

      AppStartBuilder() {
      }

      public AppStartBuilder entry(final String entry) {
         this.entry = entry;
         this.entry$set = true;
         return this;
      }

      public AppStartBuilder open_ad_id(final Long open_ad_id) {
         this.open_ad_id = open_ad_id;
         this.open_ad_id$set = true;
         return this;
      }

      public AppStartBuilder open_ad_ms(final Integer open_ad_ms) {
         this.open_ad_ms = open_ad_ms;
         this.open_ad_ms$set = true;
         return this;
      }

      public AppStartBuilder open_ad_skip_ms(final Integer open_ad_skip_ms) {
         this.open_ad_skip_ms = open_ad_skip_ms;
         this.open_ad_skip_ms$set = true;
         return this;
      }

      public AppStartBuilder loading_time(final Integer loading_time) {
         this.loading_time = loading_time;
         this.loading_time$set = true;
         return this;
      }

      public AppStartBuilder first_open(final Integer first_open) {
         this.first_open = first_open;
         this.first_open$set = true;
         return this;
      }

      public AppStart build() {
         String entry = this.entry;
         if (!this.entry$set) {
            entry = AppStart.$default$entry();
         }

         Long open_ad_id = this.open_ad_id;
         if (!this.open_ad_id$set) {
            open_ad_id = AppStart.$default$open_ad_id();
         }

         Integer open_ad_ms = this.open_ad_ms;
         if (!this.open_ad_ms$set) {
            open_ad_ms = AppStart.$default$open_ad_ms();
         }

         Integer open_ad_skip_ms = this.open_ad_skip_ms;
         if (!this.open_ad_skip_ms$set) {
            open_ad_skip_ms = AppStart.$default$open_ad_skip_ms();
         }

         Integer loading_time = this.loading_time;
         if (!this.loading_time$set) {
            loading_time = AppStart.$default$loading_time();
         }

         Integer first_open = this.first_open;
         if (!this.first_open$set) {
            first_open = AppStart.$default$first_open();
         }

         return new AppStart(entry, open_ad_id, open_ad_ms, open_ad_skip_ms, loading_time, first_open);
      }

      public String toString() {
         return "AppStart.AppStartBuilder(entry=" + this.entry + ", open_ad_id=" + this.open_ad_id + ", open_ad_ms=" + this.open_ad_ms + ", open_ad_skip_ms=" + this.open_ad_skip_ms + ", loading_time=" + this.loading_time + ", first_open=" + this.first_open + ")";
      }
   }
}
