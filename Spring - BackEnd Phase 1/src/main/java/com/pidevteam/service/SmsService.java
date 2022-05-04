package com.pidevteam.service;

import com.pidevteam.entity.util.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

// https://console.twilio.com/?frameUrl=%2Fconsole%3Fx-target-region%3Dus1&newCustomer=true

@Component
public class SmsService {


	/*private final String ACCOUNT_SID ="Enter the Account Sid of Twilio";
	  private final String AUTH_TOKEN = "Enter the Auth Token generated from Twilio";
	  private final String FROM_NUMBER = "Enter the mobile number generated from Twilio";*/

    private final String ACCOUNT_SID ="ACb6b4f1ba9e2393535dd7f33885d4e908";
    private final String AUTH_TOKEN = "0db394b30da2ad0520cdee7eaf48e2b5";
    private final String FROM_NUMBER = "+16812529403";

    //  private final String Reciever = "+216..." ;

    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
// Message message = Message.creator(new PhoneNumber(Reciever), new PhoneNumber(FROM_NUMBER), sms.getMessage())
        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}