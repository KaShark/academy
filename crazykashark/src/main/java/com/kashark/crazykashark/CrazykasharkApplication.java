package com.kashark.crazykashark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序类
 * @author 周思南
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.kashark.crazykashark.mapper")
public class CrazykasharkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrazykasharkApplication.class, args);
    }
}
