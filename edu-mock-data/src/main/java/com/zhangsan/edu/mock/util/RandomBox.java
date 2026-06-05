package com.zhangsan.edu.mock.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBox<T> {
   int totalWeight;
   List<RanOpt> optList;

   public static <T> Builder<T> builder() {
      return new Builder<T>();
   }

   public RandomBox(String... values) {
      this.totalWeight = 0;
      this.optList = new ArrayList();

      for(String value : values) {
         ++this.totalWeight;
         this.optList.add(new RanOpt(value, 1));
      }

   }

   public RandomBox(RanOpt<T>... opts) {
      this.totalWeight = 0;
      this.optList = new ArrayList();

      for(RanOpt opt : opts) {
         this.totalWeight += opt.getWeight();

         for(int i = 0; i < opt.getWeight(); ++i) {
            this.optList.add(opt);
         }
      }

   }

   public RandomBox(int trueWeight, int falseWeight) {
      this(new RanOpt(true, trueWeight), new RanOpt(false, falseWeight));
   }

   public RandomBox(String trueRate) {
      this(ParamUtil.checkRatioNum(trueRate), 100 - ParamUtil.checkRatioNum(trueRate));
   }

   public T getValue() {
      if (this.totalWeight == 0) {
         return null;
      } else {
         int i = (new Random()).nextInt(this.totalWeight);
         return (T)((RanOpt)this.optList.get(i)).getValue();
      }
   }

   public RanOpt<T> getRandomOpt() {
      int i = (new Random()).nextInt(this.totalWeight);
      return (RanOpt)this.optList.get(i);
   }

   public String getRandStringValue() {
      int i = (new Random()).nextInt(this.totalWeight);
      return (String)((RanOpt)this.optList.get(i)).getValue();
   }

   public Integer getRandIntValue() {
      int i = (new Random()).nextInt(this.totalWeight);
      return (Integer)((RanOpt)this.optList.get(i)).getValue();
   }

   public Boolean getRandBoolValue() {
      int i = (new Random()).nextInt(this.totalWeight);
      return (Boolean)((RanOpt)this.optList.get(i)).getValue();
   }

   public static void main(String[] args) {
      RanOpt[] opts = new RanOpt[]{new RanOpt("zhang3", 20), new RanOpt("li4", 30), new RanOpt("wang5", 50)};
      RandomBox randomBox = new RandomBox(opts);

      for(int i = 0; i < 10; ++i) {
         System.out.println(randomBox.getRandomOpt().getValue());
      }

   }

   public RandomBox(final int totalWeight, final List<RanOpt> optList) {
      this.totalWeight = 0;
      this.optList = new ArrayList();
      this.totalWeight = totalWeight;
      this.optList = optList;
   }

   public static class Builder<T> {
      List<RanOpt> optList = new ArrayList();
      int totalWeight = 0;

      public Builder add(T value, int weight) {
         RanOpt ranOpt = new RanOpt(value, weight);
         this.totalWeight += weight;

         for(int i = 0; i < weight; ++i) {
            this.optList.add(ranOpt);
         }

         return this;
      }

      public RandomBox<T> build() {
         return new RandomBox<T>(this.totalWeight, this.optList);
      }

      Builder() {
      }

      public Builder<T> totalWeight(final int totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public Builder<T> optList(final List<RanOpt> optList) {
         this.optList = optList;
         return this;
      }

      public String toString() {
         return "RandomBox.Builder(totalWeight=" + this.totalWeight + ", optList=" + this.optList + ")";
      }
   }
}
