package com.ljj.service;

import com.ljj.dao.UserDao;
import com.ljj.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/8
 * @Version V1.0
 **/
@Service
@Transactional
//@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    public void test() throws Exception {
        List<User> user = userDao.getAll();
        log.info("----------------> user: {}", user);
        User user1 = new User("eee", "eee", "eee", "angular");
        userDao.insert(user1);
        List<User> user2 = userDao.getAll();
        log.info("----------------> user: {}", user2);
        throw new RuntimeException("抛出一个运行期异常");
    }
}
