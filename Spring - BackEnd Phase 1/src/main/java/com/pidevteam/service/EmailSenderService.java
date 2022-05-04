package com.pidevteam.service;

//package com.women.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject
                 //        ,String Context
    )  {

        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("anonymousmega04@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
      //  message.setSubject(Context,"text/html");

        mailSender.send(message);


        System.out.println("Mail sent successfully..");


    }
}