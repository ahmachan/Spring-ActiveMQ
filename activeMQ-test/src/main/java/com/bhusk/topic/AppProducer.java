package com.bhusk.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created by kzyuan on 2018/3/5.
 */
public class AppProducer {

    private static final String url="tcp://127.0.0.1:61616/";
    private static final String topicName = "topic-test";
    public static void main(String[] args) throws JMSException {

        // 1.创建连接工厂connectionFactory

        ConnectionFactory connectionFactory =  new ActiveMQConnectionFactory( url );

        // 2.创建连接
        Connection connection = connectionFactory.createConnection();

        // 3.启动连接
        connection.start();

        // 4.创建session会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5.创建消息送达目标
        Destination destination = session.createTopic(topicName);

        // 6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for(int i = 0 ; i<100 ; i++){
            // 7.创建消息
            TextMessage message = session.createTextMessage("test" + i);
            // 8.发送消息
            producer.send(message);
            System.out.println("消息发送完成"+message.getText());
        }

        // 9.关闭连接
        connection.close();

    }

}
