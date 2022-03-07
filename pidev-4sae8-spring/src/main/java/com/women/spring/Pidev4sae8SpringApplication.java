package com.women.spring;

import com.women.spring.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;



@SpringBootApplication
public class Pidev4sae8SpringApplication {
    @Autowired
    private EmailSenderService SenderService;

    public static void main(String[] args) {
        SpringApplication.run(Pidev4sae8SpringApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void SendMail()  {

        SenderService.sendMail("yosser.snoussi@esprit.tn",
                "Your claim has been sent",
                "Claim");

    }
}
