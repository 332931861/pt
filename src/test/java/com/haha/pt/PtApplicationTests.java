package com.haha.pt;

import com.haha.pt.test.entity.SysUser;
import com.haha.pt.test.service.SysUserService;

import com.haha.pt.utils.DateUtils;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Test
    void testES(){
        //client.

    }

    @Test
    void testDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = simpleDateFormat.parse("2020-2-28");

        Date end = simpleDateFormat.parse("2020-3-2");

        List<Date> datesBetweenUsingJava7 = DateUtils.getDatesBetweenUsingJava7(start, end);
        for (Date date : datesBetweenUsingJava7) {
            System.out.println(simpleDateFormat.format(date));
        }


    }




}
