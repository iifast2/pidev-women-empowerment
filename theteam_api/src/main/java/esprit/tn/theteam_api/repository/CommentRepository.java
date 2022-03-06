package esprit.tn.theteam_api.repository;

import esprit.tn.theteam_api.model.Comment;
import esprit.tn.theteam_api.model.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long > {
        List<Comment> findAllByPublicationId(Long id);
     //   @Query("select  c from Comment  c join c.estimations e where c.id = e   ")
//        @Query(value = "SELECT c.* FROM comment  c , estimation e WHERE e.comment_id = c.id " +
//                "And count(e) >= (SELECT MAX (count(e))FROM comment c ,estimation e WHERE c.id = e.id ) " ,
//                nativeQuery = true)
//        List<Comment> commentsplusper();


}
