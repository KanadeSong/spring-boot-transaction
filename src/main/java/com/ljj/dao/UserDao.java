package com.ljj.dao;

import com.ljj.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2020/1/7
 * @Version V1.0
 **/
@Repository
public interface UserDao {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
