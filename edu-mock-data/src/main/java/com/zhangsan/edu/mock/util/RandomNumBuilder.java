package com.zhangsan.edu.mock.util;

import java.util.ArrayList;
import org.apache.commons.lang3.RandomUtils;

public class RandomNumBuilder {
   ArrayList<Integer> numPool = null;

   public RandomNumBuilder(int fromNum, int toNum, Integer... weights) {
      this.numPool = new ArrayList();
      int index = 0;

      for(int num = fromNum; num <= toNum; ++num) {
         if (num < weights.length) {
            Integer weight = weights[index++];

            for(int k = 0; k < weight; ++k) {
               this.numPool.add(num);
            }
         }
      }

   }

   public int getNum() {
      return (Integer)this.numPool.get(RandomUtils.nextInt(0, this.numPool.size()));
   }

   public static void main(String[] args) {
      RandomNumBuilder randomNumBuilder = new RandomNumBuilder(1, 10, new Integer[]{10, 10, 10, 10, 50, 1});

      for(int i = 0; i < 100; ++i) {
         int num = randomNumBuilder.getNum();
         System.out.println(num);
      }

   }
}
