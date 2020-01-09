package com.ljj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/9
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan("com.ljj.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
public class MultiTransactionApp {

    public static void main(String[] args) {
        SpringApplication.run(MultiTransactionApp.class, args);
    }
}
