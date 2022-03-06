package com.women.spring;

import com.women.spring.service.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class Pidev4sae8SpringApplication {

    @Autowired
    private CertificatService certificatService;

    public static void main(String[] args) {
        SpringApplication.run(Pidev4sae8SpringApplication.class, args);
    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {

      certificatService.sendSimpleEmail("Haninezayani@gmail.com",
                "This is Email Body with Attachment...",
                "This email has attachment"
        );

    }*/
}
