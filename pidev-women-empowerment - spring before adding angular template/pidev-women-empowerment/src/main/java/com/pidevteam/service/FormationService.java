package com.pidevteam.service;

 import com.pidevteam.entity.Formation;
 import com.pidevteam.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService implements ICrudRepository<Formation> {
@Autowired
    FormationRepository formationRepository ;
    @Autowired
DatabaseFileService fileService;

    @Override
    public Formation save(Formation formation) {
        return formationRepository.save(formation) ;}


    @Override
    public Formation update(Formation formation) {
        return formationRepository.save(formation) ;
    }

    @Override
    public Formation findById(Long id) {
        return formationRepository.findById(id).get() ;
    }

    @Override
    public void delete(Long id) {
         formationRepository.deleteById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }

    public Formation virer (Formation formation ) {
        return   formationRepository.save(formation) ;
    }
    public Formation sactionner (Formation formation ) {
        return formationRepository.save(formation) ;
    }
    public Formation Avertir (Formation formation ) {
        return formationRepository.save(formation) ;
    }

}
