package esprit.tn.theteam_api.repository;

import esprit.tn.theteam_api.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long > {
}
