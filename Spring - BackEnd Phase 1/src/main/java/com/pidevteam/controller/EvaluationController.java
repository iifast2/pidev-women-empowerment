package com.pidevteam.controller;

import com.pidevteam.entity.Evaluation;
import com.pidevteam.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/rating")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

   @PutMapping("/save/{user_id}/{formation_id}/{rating}")
    public Evaluation saveOrUpdateRating(
           @Valid   @RequestBody @PathVariable("user_id") Long userId,
           @Valid   @RequestBody @PathVariable("formation_id") Long formationId,
           @Valid   @RequestBody @PathVariable("rating") int rating) {

        return evaluationService.saveOrUpdateRating(userId, formationId, rating);

    }

    @PostMapping("/{user_id}/{formation_id}/{rating}")
    public Evaluation saveRating(
           @RequestBody @PathVariable("user_id") Long userId,
           @RequestBody @PathVariable("formation_id") Long formationId,
            @RequestBody @PathVariable("rating") int rating) {

        return evaluationService.saveOrUpdateRating( userId, formationId, rating);

    }

    @DeleteMapping("/{rating_id}")
    public void deleteRating(@PathVariable("rating_id") Long rating_id) {

        evaluationService.deleteRating(rating_id);

    }

    @GetMapping("/{rating_id}")
    public void getRating(@PathVariable("rating_id") Long rating_id) {

        evaluationService.fetchRating(rating_id);

    }

    @GetMapping("/")
    public void getRating() {

        evaluationService.fetchAllRating();

    }

}
