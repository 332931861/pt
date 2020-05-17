package com.haha.pt.service.impl;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageProducerServiceImpl {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /*  *//**
     * 向默认队列发送消息
     *
     * @param msg
     *//*
    public void sendMsgD(String msg) {
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(MQQueueType.MQ_DEFAULT), msg);
    }
*/
    /**
     * 向指定队列发送消息
     *
     * @param queueName 指定队列名称
     * @param msg       消息内容
     */
    @Value("${queue}")
    private String queueName;

    public void sendQueue(String msg){
        jmsMessagingTemplate.convertAndSend(queueName,msg);

    }




}
