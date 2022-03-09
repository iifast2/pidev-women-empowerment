package com.pidevteam.controller;


import com.pidevteam.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.social.facebook.api.Account;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()

public class FacebookController {
@Autowired
    private FacebookService facebookService ;
@GetMapping()
    public String ww(){
    List<String> urls = new ArrayList<>();;
    urls.add("http://localhost8080/GenerateAccesToken");

    return urls.toString();
}
    @GetMapping("/GenerateAccesToken")
public String generate(){
    return facebookService.generateFacebookAuthorizationUrl();
}
@GetMapping("/facebook")
public void generateFaceAccesToken(@RequestParam("code") String code){
    facebookService
            .generateAccessToken(code);
}
@GetMapping("/usersFeed")
    public PagedList<Post> getFacebook(String acc){

        return facebookService.getFacebook();
    }
@GetMapping("/account")
    public Account get(@RequestParam("idP") String id)
{return  facebookService.getUserFeed(id);}

}
