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
@Service()
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional()
    public void throwRuntimeException(User user) {
        List<User> userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        userDao.insert(user);
        userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        throw new RuntimeException("抛出一个运行期异常");
    }

    @Transactional()
    public void catchRuntimeException(User user) {
        List<User> userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        userDao.insert(user);
        userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        try {
            throw new RuntimeException("抛出一个运行期异常");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    @Transactional()
    public void throwExceptionNotRollback(User user) throws Exception {
        List<User> userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        userDao.insert(user);
        userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        throw new Exception("抛出一个异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public void throwExceptionRollback(User user) throws Exception {
        List<User> userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        userDao.insert(user);
        userList = userDao.getAll();
        log.info("----------------> userList: {}", userList);
        throw new Exception("抛出一个异常");
    }
}
