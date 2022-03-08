package com.pidevteam;

//import com.mailjet.client.errors.MailjetException;
import com.sun.mail.util.MailConnectException;
import org.springframework.context.ApplicationContext;
//import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.pidevteam.config.seeder.SeedByOrder;
//import com.pidevteam.proprety.FileStorageProperties;
//import com.pidevteam.entity.Mail;
import com.pidevteam.repository.RoleRepository;
//import com.pidevteam.service.MailService;
import com.pidevteam.service.UserService;
import com.sun.javafx.fxml.BeanAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;


import javax.annotation.PostConstruct;

@SpringBootApplication
//@EnableConfigurationProperties({FileStorageProperties.class})
public class Application implements CommandLineRunner {
    @Autowired
    private   RoleRepository roleRepository;


    @Autowired
    private UserService userService;
    @Autowired
    private SeedByOrder seedByOrder;

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);




/*           Mail mail = new Mail();
            mail.setMailFrom("anonymousmega04@gmail.com");
            mail.setMailTo("anonymousmega04@gmail.com");
            mail.setMailSubject("Spring Boot - Email Example");
            mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nmabttech.medium.com");

            ApplicationContext ctx = SpringApplication.run(Application.class, args);
            MailService mailService = (MailService) ctx.getBean("mailService");
            mailService.sendEmail(mail);*/
    }


    @Override
    public void run(String... args) throws Exception {
//        //roles seeder
//        if(roleRepository.findAll().isEmpty()){
//            roleRepository.save(new Role( "ADMIN", "ADMIN"));
//            roleRepository.save(new Role( "USER", "USER"));
//        }
//        //users Seeder

    }
    @PostConstruct
    public void init() throws  MailConnectException, MailSendException {
        seedByOrder.init();
      //  User  user = userService.findById(1L);
     //   userService.save(new UserDto(user.getId(), user.getUsername(), user.getPassword(), 10000000L,user.getBirthdate(), user.getAddress(), user.getLeaveBalance(), user.getCin(), user.getEmail()));
    }
}



/*
// the OLD one :

    public void init() throws MailjetSocketTimeoutException, MailjetException {
        seedByOrder.init();
      //  User  user = userService.findById(1L);
     //   userService.save(new UserDto(user.getId(), user.getUsername(), user.getPassword(), 10000000L,user.getBirthdate(), user.getAddress(), user.getLeaveBalance(), user.getCin(), user.getEmail()));
    }
}

 */