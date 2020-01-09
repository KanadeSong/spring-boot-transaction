package com.ljj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ljj.dao"})

public class TransactionConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionConfigApplication.class, args);
    }

}
