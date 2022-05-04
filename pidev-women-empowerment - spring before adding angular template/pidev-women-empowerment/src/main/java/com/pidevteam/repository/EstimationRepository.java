package com.pidevteam.repository;


import com.pidevteam.entity.Emoji;
import com.pidevteam.entity.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstimationRepository extends JpaRepository<Estimation, Long > {
    List<Estimation> findAllByCommentId(Long id);
    List<Estimation> findAllByCommentIdAndEmoji(Long id, Emoji emoji);
Long  countAllByCommentId(Long id) ;

}
