package com.pidevteam.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//DemoController
public class ActuatorController {
    @GetMapping("/get-info")
    public String getStringMessage() {
        return "Hi ! You will be able to monitor health of the application !!" ;
    }
}