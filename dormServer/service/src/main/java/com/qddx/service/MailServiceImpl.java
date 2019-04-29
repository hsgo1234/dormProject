package com.qddx.service;

import com.qddx.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



/**
 * @Description:
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/14 19:43
 */
@Component
public class MailServiceImpl {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String Sender;

    public void sendSimpleMail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(email.getTo());
        message.setSubject(email.getTheme());
        message.setText(email.getContent());
        try {
            mailSender.send(message);
            System.out.println("sending ...."+email.toString());
        }catch (Exception e){
            System.out.println("error: "+e);
        }
    }
}
