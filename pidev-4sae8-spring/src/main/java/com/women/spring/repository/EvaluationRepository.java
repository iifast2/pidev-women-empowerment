package com.women.spring.repository;

import com.women.spring.model.Evaluation;

import com.women.spring.model.Formation;
import com.women.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "rating", path = "rating")
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
    List<Evaluation> findByRating(@Param("rating") int rating);
    List<Evaluation> findByFormation(@Param("formation") Optional<Formation> formation);
    List<Evaluation> findByUser(@Param("user") User user);

}
