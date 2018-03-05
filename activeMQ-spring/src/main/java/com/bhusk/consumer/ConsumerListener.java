package com.bhusk.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by kzyuan on 2018/3/5.
 */
public class ConsumerListener implements MessageListener{

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接受消息为"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
