package com.effort.demo.jms;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component("consumerMessageListener2")
public class ConsumerLister2 implements SessionAwareMessageListener {

    private Destination destination;
    private Destination replyDestination;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        //通过session 创建  producer对象，再回送信息
        //从message中取出信息回送的目的地,以便创建生产者.
        MessageProducer producer = session.createProducer(message.getJMSReplyTo());
        //创建一条消息
        Message textMessage = session.createTextMessage("生产者发过来的信息已经处理完毕，game over...");
        //调用发送
        producer.send(textMessage);
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setReplyDestination(Destination replyDestination) {
        this.replyDestination = replyDestination;
    }
}
