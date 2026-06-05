package com.zhangsan.edu.mock.util;

import java.util.Date;
import java.util.Random;

public class RandomDate {
   Long logDateTime = 0L;
   int maxTimeStep = 0;

   public RandomDate(Date startDate, Date endDate, int num) {
      Long avgStepTime = (endDate.getTime() - startDate.getTime()) / (long)num;
      this.maxTimeStep = avgStepTime.intValue() * 2;
      this.logDateTime = startDate.getTime();
   }

   public Date getRandomDate() {
      int timeStep = (new Random()).nextInt(this.maxTimeStep);
      this.logDateTime = this.logDateTime + (long)timeStep;
      return new Date(this.logDateTime);
   }
}
