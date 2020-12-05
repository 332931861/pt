package com.haha.pt.test.service.serviceImpl;

import com.haha.pt.test.dao.UserDao;
import com.haha.pt.test.entity.User;
import com.haha.pt.test.service.UserService;
import com.haha.pt.test.web.TestDataSourceController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public User selectById(String id) {
        long start,end;
        start = System.currentTimeMillis();
        User user = userDao.selectById(id);
        end = System.currentTimeMillis();
        logger.info("selectById花费"+(start-end)+"ms");
        return user;
    }

    @Override
    public List<User> selectByName(String name) {
        long start,end;
        start = System.currentTimeMillis();
        List<User> list = userDao.selectByName(name);
        end = System.currentTimeMillis();
        logger.info("selectByName花费"+(start-end)+"ms");
        return list;
    }

    @Override
    public List<User> selectByNameAndPhone(User user) {
        long start,end;
        start = System.currentTimeMillis();
        List<User> list = userDao.selectByNameAndPhone(user);
        end = System.currentTimeMillis();
        logger.info("selectByNameAndPhone花费"+(start-end)+"ms");
        return list;

    }

    @Override
    public List<User> selectByNameAndPhoneAndTime(User user) {
        long start,end;
        start = System.currentTimeMillis();
        List<User> list = userDao.selectByNameAndPhoneAndTime(user);
        end = System.currentTimeMillis();
        logger.info("selectByNameAndPhoneAndTime花费"+(start-end)+"ms");
        return list;
    }

    @Override
    public List<User> selectByUser(User user) {
        long start,end;
        start = System.currentTimeMillis();
        List<User> list = userDao.selectByUser(user);
        end = System.currentTimeMillis();
        logger.info("selectByUser"+(start-end)+"ms");
        return list;
    }

    @Override
    public void insertUser(User user) {
        long start,end;
        start = System.currentTimeMillis();
        userDao.insertUser(user);
        end = System.currentTimeMillis();
        logger.info("insertUser"+(start-end)+"ms");
    }

    @Override
    public void updateById(User user) {
        long start,end;
        start = System.currentTimeMillis();
        userDao.updateById(user);
        end = System.currentTimeMillis();
        logger.info("updateById"+(start-end)+"ms");

    }
}
