package com.ljj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/8
 * @Version V1.0
 **/
@Service
public class TestService {

    @Transactional
    public void userUpdate(){
        //用户修改操作
        try {
            systemDelete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void systemDelete(){
        //更新系统数据操作
        throw  new RuntimeException("抛出一个更新系统失败的运行期异常");
    }
}
