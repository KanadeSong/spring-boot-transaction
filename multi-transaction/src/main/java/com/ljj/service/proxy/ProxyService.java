package com.ljj.service.proxy;

import com.ljj.dao.UserDao;
import com.ljj.entity.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/9
 * @Version V1.0
 **/
@Service
@Slf4j
public class ProxyService {

    @Autowired
    private UserDao userDao;

    @SneakyThrows
    @Transactional
    public void userUpdate(User user) {
        userDao.insert(user);
        log.info("------------->userList: {}", userDao.getAll());
        ((ProxyService) AopContext.currentProxy()).systemInsert(user);
        throw new RuntimeException("抛出一个删除系统数据失败的运行期异常！");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void systemInsert(User user) {
        String userName = user.getUserName();
        user.setUserName(userName + ":update");
        userDao.insert(user);
        log.info("------------->userList: {}", userDao.getAll());
    }
}
