package esprit.tn.theteam_api.service;


import esprit.tn.theteam_api.model.Publication;
import esprit.tn.theteam_api.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService implements  ICrudService<Publication>{

    @Autowired
    PublicationRepository publicationRepository;

    @Override
    public Publication save(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public Publication Update(Publication publication) {
        return publicationRepository.save(publication);

    }

    @Override
    public List<Publication> findAll() {
        return publicationRepository.findAll() ;

    }

    @Override
    public Publication findById(Long id) {
        return publicationRepository.findById(id).get();

    }

    @Override
    public void deleteById(Long id) {
       publicationRepository.deleteById(id);

    }


    public List<Publication> findAllByDateCreation() {

     //   return publicationRepository.newPublication() ;
        return  publicationRepository.findAllByOrderByDateCreationDesc();

    }
    public List<Publication> filter(Publication p){
        //List<Publication> lst = new ArrayList<>();
        return  publicationRepository.filter(p.getTopic(),p.getMood() ,p.getLocation() , p.getDateCreation());
    }


}
