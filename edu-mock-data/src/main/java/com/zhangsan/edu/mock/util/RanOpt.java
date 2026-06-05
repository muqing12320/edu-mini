package com.zhangsan.edu.mock.util;

public class RanOpt<T> {
   T value;
   int weight;

   public RanOpt(T value, int weight) {
      this.value = value;
      this.weight = weight;
   }

   public T getValue() {
      return this.value;
   }

   public int getWeight() {
      return this.weight;
   }
}
