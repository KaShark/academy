package com.kashark.crazykashark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 应用程序类
 * @author 周思南
 * @version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class CrazykasharkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrazykasharkApplication.class, args);
    }
}
