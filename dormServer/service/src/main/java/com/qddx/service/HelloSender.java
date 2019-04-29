package com.qddx.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/14 16:52
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String username) {
        String context = username;
        System.out.println("Sender:"+username);
        this.rabbitTemplate.convertAndSend("exchange","topic.q",context);
    }
}
