package com.ljj.service;

import com.ljj.dao.UserDao;
import com.ljj.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/9
 * @Version V1.0
 **/
@Service
@Slf4j
public class MultiServiceB {

    @Autowired
    private UserDao userDao;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void UserInsert(User user){
        userDao.insert(user);
        List<User> userList = userDao.getAll();
        log.info("------------->userList: {}",userList);

    }
}
