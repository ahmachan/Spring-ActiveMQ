package com.bhusk.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kzyuan on 2018/3/5.
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i <100 ; i++) {
            service.sendMessage("hello world"+i);
        }
        context.close();
    }

}
