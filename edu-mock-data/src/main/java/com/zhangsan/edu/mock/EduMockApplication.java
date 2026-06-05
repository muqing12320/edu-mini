package com.zhangsan.edu.mock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(
   basePackages = {"com.zhangsan.edu.mock.mapper"}
)
public class EduMockApplication {
   public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(EduMockApplication.class, args);
      MockTask mockTask = (MockTask)context.getBean(MockTask.class);
      mockTask.mainTask();
   }
}
