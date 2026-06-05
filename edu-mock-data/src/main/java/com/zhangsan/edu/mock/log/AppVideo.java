package com.zhangsan.edu.mock.log;

public class AppVideo {
   String video_id;
   Integer play_sec;
   Integer position_sec;

   public static AppVideoBuilder builder() {
      return new AppVideoBuilder();
   }

   public String getVideo_id() {
      return this.video_id;
   }

   public Integer getPlay_sec() {
      return this.play_sec;
   }

   public Integer getPosition_sec() {
      return this.position_sec;
   }

   public void setVideo_id(final String video_id) {
      this.video_id = video_id;
   }

   public void setPlay_sec(final Integer play_sec) {
      this.play_sec = play_sec;
   }

   public void setPosition_sec(final Integer position_sec) {
      this.position_sec = position_sec;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppVideo)) {
         return false;
      } else {
         AppVideo other = (AppVideo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$video_id = this.getVideo_id();
            Object other$video_id = other.getVideo_id();
            if (this$video_id == null) {
               if (other$video_id != null) {
                  return false;
               }
            } else if (!this$video_id.equals(other$video_id)) {
               return false;
            }

            Object this$play_sec = this.getPlay_sec();
            Object other$play_sec = other.getPlay_sec();
            if (this$play_sec == null) {
               if (other$play_sec != null) {
                  return false;
               }
            } else if (!this$play_sec.equals(other$play_sec)) {
               return false;
            }

            Object this$position_sec = this.getPosition_sec();
            Object other$position_sec = other.getPosition_sec();
            if (this$position_sec == null) {
               if (other$position_sec != null) {
                  return false;
               }
            } else if (!this$position_sec.equals(other$position_sec)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppVideo;
   }

   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $video_id = this.getVideo_id();
      result = result * 59 + ($video_id == null ? 43 : $video_id.hashCode());
      Object $play_sec = this.getPlay_sec();
      result = result * 59 + ($play_sec == null ? 43 : $play_sec.hashCode());
      Object $position_sec = this.getPosition_sec();
      result = result * 59 + ($position_sec == null ? 43 : $position_sec.hashCode());
      return result;
   }

   public String toString() {
      return "AppVideo(video_id=" + this.getVideo_id() + ", play_sec=" + this.getPlay_sec() + ", position_sec=" + this.getPosition_sec() + ")";
   }

   public AppVideo(final String video_id, final Integer play_sec, final Integer position_sec) {
      this.video_id = video_id;
      this.play_sec = play_sec;
      this.position_sec = position_sec;
   }

   public static class AppVideoBuilder {
      private String video_id;
      private Integer play_sec;
      private Integer position_sec;

      AppVideoBuilder() {
      }

      public AppVideoBuilder video_id(final String video_id) {
         this.video_id = video_id;
         return this;
      }

      public AppVideoBuilder play_sec(final Integer play_sec) {
         this.play_sec = play_sec;
         return this;
      }

      public AppVideoBuilder position_sec(final Integer position_sec) {
         this.position_sec = position_sec;
         return this;
      }

      public AppVideo build() {
         return new AppVideo(this.video_id, this.play_sec, this.position_sec);
      }

      public String toString() {
         return "AppVideo.AppVideoBuilder(video_id=" + this.video_id + ", play_sec=" + this.play_sec + ", position_sec=" + this.position_sec + ")";
      }
   }
}
