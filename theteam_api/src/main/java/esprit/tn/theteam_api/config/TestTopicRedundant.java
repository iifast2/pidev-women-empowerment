package esprit.tn.theteam_api.config;
import esprit.tn.theteam_api.model.Publication ;
import esprit.tn.theteam_api.repository.PublicationRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class TestTopicRedundant {
    @Autowired
    PublicationRepository publicationRepository ;
@After("execution(public * esprit.tn.theteam_api.service.PublicationService.deleteById(..))")
    public void after(){
    List<Publication> lst = publicationRepository.findAllByOrderByDateCreationAsc() ;
    if(lst != null){
        for (Publication p: lst) {
            if(p.getDateCreation().before(new Date()) &&  publicationRepository.countByTopic(p.getTopic())> 1){
                publicationRepository.deleteById(p.getId());
            }

        }
    }

}


}
