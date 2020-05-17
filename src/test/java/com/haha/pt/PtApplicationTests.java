package com.haha.pt;

import com.haha.pt.test.dao.SysUserDao;
import com.haha.pt.test.entity.SysUser;
import com.haha.pt.test.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PtApplicationTests {

    @Autowired
    private SysUserService sysUserService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMysqlConnect(){
        List<SysUser> sysUsers = sysUserService.queryAll();
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }
}
