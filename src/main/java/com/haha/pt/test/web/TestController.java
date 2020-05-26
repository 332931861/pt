package com.haha.pt.test.web;

import com.haha.pt.service.impl.MessageProducerServiceImpl;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);
    @Autowired
    private MessageProducerServiceImpl product;

    @RequestMapping("/a")
    @ResponseBody
    public String testLogger(){
        logger.info("hahaaha");
        return "success";
    }

    @RequestMapping("/send")
    public void sendQueue(String msg){
        product.sendQueue(msg);
    }


    @RequestMapping("/session")
    @ResponseBody
    public String testSessionTime(HttpServletRequest request){
        request.getSession().setMaxInactiveInterval(24 * 60 * 60);

        logger.info("session过期时间为"+request.getSession().getMaxInactiveInterval()+"s");
        return "success";
    }
    @RequestMapping("/exce")
    @ResponseBody
    public String testException(HttpServletRequest request){
        try {
            String a = "asdfasdf";
            String b = "1231234";
            Integer c = Integer.valueOf(b);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.error("转换错误");
        }


        return "success";
    }

}
