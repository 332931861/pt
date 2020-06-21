package com.haha.pt;

import com.haha.pt.test.dao.TeacherDao;
import com.haha.pt.test.entity.SysUser;
import com.haha.pt.test.entity.Teacher;
import com.haha.pt.test.service.SysUserService;

import com.haha.pt.utils.DateUtils;
import org.checkerframework.checker.units.qual.A;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PtApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TransportClient client;
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testMysqlConnect(){
        /*List<SysUser> sysUsers = sysUserService.queryAll();
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }*/
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

    @Test
    void testStu(){

        /*List<Teacher> teachers = teacherDao.queryAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }*/

    }



}
