package com.pidevteam.repository;

import com.pidevteam.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long > {
        List<Comment> findByPublicationId(Long id);
     //   @Query("select  c from Comment  c join c.estimations e where c.id = e   ")
//        @Query(value = "SELECT c.* FROM comment  c , estimation e WHERE e.comment_id = c.id " +
//                "And count(e) >= (SELECT MAX (count(e))FROM comment c ,estimation e WHERE c.id = e.id ) " ,
//                nativeQuery = true)
//        List<Comment> commentsplusper();


}
