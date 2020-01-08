package com.ljj.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/7
 * @Version V1.0
 **/
public class RDBMSSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;

    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;

    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;

    @Value("${spring.datasource.maxWait}")
    private Integer maxWait;

    @Value("${mybatis.type-aliases-package}")
    private String PACKAGE;
    @Value("${mybatis.mapper-locations}")
    private String LOCATION;


}
