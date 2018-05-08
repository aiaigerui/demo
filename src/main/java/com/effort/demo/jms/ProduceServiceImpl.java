package com.effort.demo.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;

@Component("produceServiceImpl")
public class ProduceServiceImpl implements ProduceService {

    @Resource
    private JmsTemplate jmsTemplate;
    @Resource(name = "sendQueueDestination")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        System.out.println("生产者发送消息" + message);

        //回调
        jmsTemplate.send(destination, session -> {
            //创建一个文本消息
            Message msg = session.createTextMessage(message);
            //指定为非持久化方式
            msg.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            return msg;
        });
    }

}
