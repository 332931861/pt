package com.haha.pt.service.impl;

import com.haha.pt.utils.MQQueueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerServiceImpl {
    private static final Logger log = LoggerFactory.getLogger("active");
    @JmsListener(destination = MQQueueType.MQ_DEFAULT)
    public void defaultMq(String text) {
        log.info("【*** " + MQQueueType.MQ_DEFAULT + " 接收消息 ***】" + text);
    }
    //destination是指 该消费者监听的队列名称
    /*@JmsListener(destination = MQQueueType.MQ_STUDY)
    public void receiveMessage(String text) {
        log.info("【*** " + MQQueueType.MQ_STUDY + " 接收消息 ***】" + text);
    }
    //destination是指 该消费者监听的队列名称
    @JmsListener(destination = MQQueueType.MQ_GOODS)
    public void receiveGoodsMessage(String text) {
        log.info("【*** " + MQQueueType.MQ_GOODS + " 接收消息 ***】" + text);
    }*/

}
