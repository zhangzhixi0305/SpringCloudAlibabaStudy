package com.zhixi;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName BookApplication
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 17:35
 * @Version 1.0
 */
/*分布式事务自动代理*/
@EnableAutoDataSourceProxy
@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
