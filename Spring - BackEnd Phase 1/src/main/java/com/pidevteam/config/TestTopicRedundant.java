package com.pidevteam.config;

import com.pidevteam.entity.Publication;
import com.pidevteam.repository.PublicationRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Aspect
@Component
public class TestTopicRedundant {
    @Autowired
    PublicationRepository publicationRepository ;
@After("execution(public * com.pidevteam.service.PublicationService.deleteById(..))")
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
