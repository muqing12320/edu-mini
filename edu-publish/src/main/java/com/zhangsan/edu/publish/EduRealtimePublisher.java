package com.zhangsan.edu.publish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zhangsan.edu.publish.mapper")
public class EduRealtimePublisher {

    public static void main(String[] args) {
        SpringApplication.run(EduRealtimePublisher.class, args);
    }

}
