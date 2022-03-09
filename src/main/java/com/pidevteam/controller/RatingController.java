package com.pidevteam.controller;

import com.pidevteam.entity.Rating;
import com.pidevteam.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService ;
    @PostMapping("/{id}")
    public Rating save(@RequestBody Rating rating , @PathVariable("id") Long id){
        return  ratingService.save(id,rating) ;
    }
    @GetMapping("/{id}")
    public List<Rating>findAllByPublicationId (@PathVariable("id") Long id){
        return  ratingService.findAllByPublicationId(id);
    }
}
