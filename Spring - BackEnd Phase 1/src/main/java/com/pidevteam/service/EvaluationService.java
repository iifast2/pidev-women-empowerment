package com.pidevteam.service;


  import com.pidevteam.exception.RecordNotFoundException;
  import com.pidevteam.entity.Evaluation;
  import com.pidevteam.entity.Formation;
  import com.pidevteam.entity.User;
  import com.pidevteam.repository.EvaluationRepository;
  import com.pidevteam.repository.FormationRepository;
  import com.pidevteam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService{
    @Autowired
    EvaluationRepository ratingRepo  ;
    @Autowired
    UserRepository userRepo;
    @Autowired
    FormationRepository formationRepo;

    @Transactional
public Evaluation saveOrUpdateRating(Long userId, Long formationId, int rating) {

   Formation formation= formationRepo.findById(formationId)
            .orElseThrow(RecordNotFoundException::new);

    User user = userRepo.findById(userId)
            .orElseThrow(RecordNotFoundException::new);

    List<Evaluation> reviews = ratingRepo.findByFormation(Optional.ofNullable(formation));

    Evaluation review;

    if(reviews == null) {
        review = Evaluation.builder().formation(formation)
                .user(user).rating(rating).build();

        ratingRepo.save(review);

    } else {

        for(Evaluation r : reviews) {

            if(r.getUser().getId() == userId){

                r.setRating(rating);
                ratingRepo.save(r);

                return r;

            }

        }
        review =Evaluation.builder().formation(formation)
                .user(user).rating(rating).build();

        ratingRepo.save(review);

    }
    return review;
}

    @Transactional
    public void deleteRating(Long rating_id) {

        ratingRepo.deleteById(rating_id);

    }

    @Transactional
    public Evaluation fetchRating(Long rating_id) {

        return ratingRepo.findById(rating_id)
                .orElseThrow(RecordNotFoundException::new);

    }

    @Transactional
    public List<Evaluation> fetchAllRating() {

        return ratingRepo.findAll();

    }
}
