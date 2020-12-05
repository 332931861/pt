package com.haha.pt.test.dao;

import com.haha.pt.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User selectById(String id);
    List<User> selectByName(String name);
    List<User> selectByNameAndPhone(User user);
    List<User> selectByNameAndPhoneAndTime(User user);
    List<User> selectByUser(User user);
    void insertUser(User user);
    void updateById(User user);
}

