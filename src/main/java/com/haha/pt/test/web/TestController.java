package com.haha.pt.test.web;

import com.haha.pt.service.impl.MessageProducerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
