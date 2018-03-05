package com.bhusk.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kzyuan on 2018/3/5.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
