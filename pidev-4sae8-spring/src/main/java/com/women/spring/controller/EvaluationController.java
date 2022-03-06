package com.women.spring.controller;

import com.women.spring.model.Evaluation;

import com.women.spring.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/rating")
public class EvaluationController {

    @Autowired
    EvaluationService ratingsService;

   @PutMapping("/save/{user_id}/{formation_id}/{rating}")
    public Evaluation saveOrUpdateRating(
           @Valid   @RequestBody @PathVariable("user_id") Long userId,
           @Valid   @RequestBody @PathVariable("formation_id") Long formationId,
           @Valid   @RequestBody @PathVariable("rating") int rating) {

        return ratingsService.saveOrUpdateRating(userId, formationId, rating);

    }

    @PostMapping("/{user_id}/{formation_id}/{rating}")
    public Evaluation saveRating(
           @RequestBody @PathVariable("user_id") Long userId,
           @RequestBody @PathVariable("formation_id") Long formationId,
            @RequestBody @PathVariable("rating") int rating) {

        return ratingsService.saveOrUpdateRating( userId, formationId, rating);

    }

    @DeleteMapping("/{rating_id}")
    public void deleteRating(@PathVariable("rating_id") Long rating_id) {

        ratingsService.deleteRating(rating_id);

    }

    @GetMapping("/{rating_id}")
    public void getRating(@PathVariable("rating_id") Long rating_id) {

        ratingsService.fetchRating(rating_id);

    }

    @GetMapping("/")
    public void getRating() {

        ratingsService.fetchAllRating();

    }

}
