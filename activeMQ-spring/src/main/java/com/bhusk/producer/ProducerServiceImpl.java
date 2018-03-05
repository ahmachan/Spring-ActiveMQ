package com.bhusk.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by kzyuan on 2018/3/5.
 */
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "topicDestination")
    private Destination destination;

    public void sendMessage(final String message) {
        // 使用jmstemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                // 创建消息体
                TextMessage textmessage = session.createTextMessage(message);
                System.out.println("消息已经发送"+message);
                return textmessage;
            }
        });
    }
}
