package com.zhangsan.edu.mock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class PoolConfig {
   @Bean
   public ThreadPoolTaskExecutor getPoolExecutor() {
      ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
      threadPoolTaskExecutor.setCorePoolSize(100);
      threadPoolTaskExecutor.setQueueCapacity(10000);
      threadPoolTaskExecutor.setMaxPoolSize(400);
      threadPoolTaskExecutor.initialize();
      return threadPoolTaskExecutor;
   }
}
