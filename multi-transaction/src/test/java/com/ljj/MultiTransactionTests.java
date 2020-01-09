package com.ljj;

import com.ljj.entity.User;
import com.ljj.service.MultiServiceA;
import com.ljj.service.proxy.ProxyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/9
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiTransactionTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MultiServiceA serviceA;

    @Autowired
    private ProxyService proxyService;


    private User getUser() {
        return User.builder().userName("jojo").passWord("dio").userSex("van").nickName("dio").build();
    }

    @Test
    public void test() {
        serviceA.userUpdate(getUser());
    }

    @Test
    public void test2() {
        serviceA.userUpdate2(getUser());
    }

    @Test
    public void proxyTest() {
        proxyService.userUpdate(getUser());
    }
}
