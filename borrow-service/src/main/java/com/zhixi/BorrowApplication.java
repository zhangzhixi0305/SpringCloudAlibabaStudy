package com.zhixi;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName BorrowApplication
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 17:36
 * @Version 1.0
 */
@EnableAutoDataSourceProxy
@EnableFeignClients
@SpringBootApplication
public class BorrowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class, args);
    }
}
