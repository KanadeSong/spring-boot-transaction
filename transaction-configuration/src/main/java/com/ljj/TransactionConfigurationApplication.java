package com.ljj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ljj.dao"})
public class TransactionConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionConfigurationApplication.class, args);
    }

}
