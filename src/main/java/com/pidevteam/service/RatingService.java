package com.pidevteam.service;

import com.pidevteam.entity.Rating;
import com.pidevteam.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
@Autowired
    RatingRepository ratingRepository ;
@Autowired
PublicationService publicationService ;
public Rating save(Long id, Rating rating){
    rating.setPublication(publicationService.findById(id));
     return  ratingRepository.save(rating);
}
   public List<Rating> findAllByPublicationId(Long id){
    return ratingRepository.findAllByPublicationId(id);
    }
}
