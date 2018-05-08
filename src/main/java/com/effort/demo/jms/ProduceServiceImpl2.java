package com.effort.demo.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

@Service("produceServiceImpl2")
public class ProduceServiceImpl2 implements ProduceService {

    @Resource(name = "sendQueueDestination")
    private Destination destination;
    @Resource
    private JmsTemplate jmsTemplate;
    @Resource(name = "replyQueueDestination")
    private Destination replyQueueDestination;

    @Override
    public void sendMessage(final String message) {
        System.out.println("生产者2->发送消息" + message);
        // 回调
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createTextMessage(message);
                // 设置回复的信息的目的地.
                msg.setJMSReplyTo(replyQueueDestination);
                // 设置发送的信息类型 为非持久化信息
                msg.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);

                //创建一个消费者，用于接收对方回复的信息   注意，这个消费者临听   replyDestination
                MessageConsumer comsumer2 = session.createConsumer(replyQueueDestination);
                comsumer2.setMessageListener(new MessageListener() {
                    public void onMessage(Message m) {
                        try {
                            System.out.println("接收到的回复信息:" + ((TextMessage) m).getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return msg;
            }
        });
    }
}
