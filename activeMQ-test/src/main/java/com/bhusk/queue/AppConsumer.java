package com.bhusk.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by kzyuan on 2018/3/5.
 */
public class AppConsumer {
    private static final String url="tcp://127.0.0.1:61616/";
    private static final String queueName = "queue-test";

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
        Destination destination = session.createQueue(queueName);

        // 6.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7.创建监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println("接受的消息为："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 8.关闭连接
        //connection.close();

    }
}
