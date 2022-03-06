package esprit.tn.theteam_api.repository;

import esprit.tn.theteam_api.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long > {
    List<Rating> findAllByPublicationId(Long id);
}
