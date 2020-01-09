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
public class MultiServiceA {


    @Autowired
    private UserDao userDao;

    @Autowired
    private MultiServiceB serviceB;

    @Transactional
    public void userUpdate(User user){
        userDao.insert(user);
        List<User> userList = userDao.getAll();
        log.info("------------->userList: {}",userList);
        systemInsert(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void systemInsert(User user){
        String userName = user.getUserName();
        user.setUserName(userName + ":update");
        userDao.insert(user);
        List<User> userList = userDao.getAll();
        log.info("------------->userList: {}",userList);
        throw  new RuntimeException("抛出一个删除系统数据失败的运行期异常！");
    }

    @Transactional
    public void userUpdate2(User user){
        serviceB.UserInsert(user);
        String userName = user.getUserName();
        user.setUserName(userName + ":update");
        userDao.insert(user);
        List<User> userList = userDao.getAll();
        log.info("------------->userList: {}",userList);
        throw  new RuntimeException("抛出一个删除系统数据失败的运行期异常！");
    }

}
