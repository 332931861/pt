package com.haha.pt.test.service.serviceImpl;

import com.haha.pt.test.dao.SysUserDao;
import com.haha.pt.test.entity.SysUser;
import com.haha.pt.test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> queryAll() {
        return sysUserDao.queryAll();
    }
}
