package com.pidevteam.service;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.social.facebook.api.Account;

import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;


@Service
public class FacebookService {
    private String accesToken ;
@Value("${spring.social.facebook.appId}")
private  String appId ;
    @Value("${spring.social.facebook.appSecret}")
    private  String appSecret ;
private  FacebookConnectionFactory createConnection(){
    return  new FacebookConnectionFactory(appId,appSecret);
}
public String generateFacebookAuthorizationUrl(){
     OAuth2Parameters params = new OAuth2Parameters();
     params.setRedirectUri("http://localhost8080/facebook");
     params.setScope("email");
      return createConnection().getOAuthOperations().buildAuthenticateUrl(params);
}
    public void  generateAccessToken(String code){
    accesToken = createConnection().getOAuthOperations().exchangeForAccess(code,"http://localhost8080/facebook",null).getAccessToken();
    }
    public PagedList<Post> getFacebook(){
    return  new FacebookTemplate(accesToken).feedOperations().getFeed();
    }
    public Account getUserFeed(String idP){
    return  new FacebookTemplate(accesToken).pageOperations().getAccount(idP);
    }

}