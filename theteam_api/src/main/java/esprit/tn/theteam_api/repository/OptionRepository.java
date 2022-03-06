package esprit.tn.theteam_api.repository;


import esprit.tn.theteam_api.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long > {

    List<Option> findAllBySurveyId(Long idS);
}
