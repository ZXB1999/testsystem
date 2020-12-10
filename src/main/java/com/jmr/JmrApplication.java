package com.jmr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
//@ComponentScan(value = "com.jmr")//扫描注解元素
@MapperScan("com.jmr.dao")//Mybatis的DAO所在包
public class JmrApplication {
    public static void main(String[] args) {
        SpringApplication.run(JmrApplication.class, args);
    }
}
