package esprit.tn.theteam_api.repository;

import esprit.tn.theteam_api.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long > {
}
