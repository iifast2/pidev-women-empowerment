package com.pidevteam.controller;

import com.pidevteam.config.TokenProvider;
import com.pidevteam.entity.util.AuthToken;
import com.pidevteam.entity.util.LoginUser;
//import com.pidevteam.service.EmailService;
import com.pidevteam.service.UserService;
import com.sendgrid.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {

   // @Autowired
    //EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));


/*        sendMail(
                "Authdaritn@gmail.com",
                "Your login code ",
                "+\n your user name is " + loginUser.getUsername() );*/


       // mail.setMailFrom("YourGmailAddress@gmail.com");
      //  mail("YourGmailAddress@gmail.com");
       // mail.setMailSubject("Spring Boot - Email Example");
       // mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nmabttech.medium.com");


       // MailService mailService = (MailService) ctx.getBean("mailService");
       // mailService.sendMail(mail);


    }


}
