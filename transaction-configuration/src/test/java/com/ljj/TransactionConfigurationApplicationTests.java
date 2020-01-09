package com.ljj;

import com.ljj.entity.User;
import com.ljj.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class TransactionConfigurationApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    private User getUser() {
        return User.builder().userName("fff").passWord("fff").userSex("avc").nickName("ace").build();
    }

    @Test
    void testThrowRuntimeException() {
        userService.throwRuntimeException(getUser());
    }

    @Test
    void testCatchRuntimeException() {
        userService.catchRuntimeException(getUser());
    }


    @Test
    void testThrowExceptionNotRollback() throws Exception {
        userService.throwExceptionNotRollback(getUser());
    }

    @Test
    void testThrowExceptionRollback() throws Exception {
        userService.throwExceptionRollback(getUser());
    }

}
