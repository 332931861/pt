package com.haha.pt.test.service;

import com.haha.pt.test.entity.User;

import java.util.List;

public interface UserService {
    User selectById(String id);
    List<User> selectByName(String name);
    List<User> selectByNameAndPhone(User user);
    List<User> selectByNameAndPhoneAndTime(User user);
    List<User> selectByUser(User user);
    void insertUser(User user);
    void updateById(User user);
}
