package com.ljj;

import com.ljj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/8
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        try {
            userService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
