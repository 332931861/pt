package com.haha.pt.test.web;

import com.haha.pt.test.entity.User;
import com.haha.pt.test.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/testDataSource")
public class TestDataSourceController {
    private Logger logger = Logger.getLogger(TestDataSourceController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/selectById")
    @ResponseBody
    public String selectById(){
        try {
            User user = userService.selectById("000096d8-c3e3-4d3a-96f0-137bdfe12344");
            logger.info(user);
            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public String selectByName(){
        try {
            List<User> list = userService.selectByName("名字9981745");
            logger.info(list);
            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }

    @RequestMapping("/selectByNameAndPhone")
    @ResponseBody
    public String selectByNameAndPhone(){
        try {
            User user = new User();
            user.setUserName("名字971341");
            user.setPhone("13392253693");
            List<User> list = userService.selectByNameAndPhone(user);
            logger.info(list);
            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }

    @RequestMapping("/selectByUser")
    @ResponseBody
    public String selectByUser(){
        try {
            User user = new User();
            //user.setUserName("名字971341");
            //user.setPhone("13392253693");
            //user.setCity("367");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = simpleDateFormat.parse("2020-07-14 23:03:02");
            user.setProvince("11");
            user.setCreateTime(parse);
            List<User> list = userService.selectByUser(user);
            logger.info(list);
            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(){
        try {
            User user = new User();
            //user.setUserName("名字971341");
            //user.setPhone("13392253693");
            //user.setCity("367");
            String uuid =UUID.randomUUID().toString();
            logger.info(uuid);
            user.setId(uuid);
            user.setUserName("2名字971346");
            user.setAge(25);
            user.setPhone("13292256648");
            user.setProvince("11");
            user.setCity("168");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            System.out.println(user.getId());
            userService.insertUser(user);

            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }


    @RequestMapping("/updateById")
    @ResponseBody
    public String updateById(){
        try {
            User user = new User();
            //user.setUserName("名字971341");
            //user.setPhone("13392253693");
            //user.setCity("367");

            user.setId("0c0e1322-8bd5-41d6-8fc4-bb1639641729");
            user.setUserName("1名字971346");
            user.setAge(25);
            user.setUpdateTime(new Date());
            System.out.println(user.getId());
            userService.updateById(user);

            return "success";
        } catch (Exception e) {
            logger.error("error",e);
            return "error";
        }
    }

}
