package com.pidevteam.repository;

import com.pidevteam.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long > {
    List<Rating> findAllByPublicationId(Long id);
}
