package esprit.tn.theteam_api.service;

import esprit.tn.theteam_api.model.Publicity;
import esprit.tn.theteam_api.repository.PublicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicityService implements  ICrudService<Publicity>{

    @Autowired
    PublicityRepository publicityRepository;
    public Publicity save (Publicity publicity){
        return publicityRepository.save(publicity) ;
    }

    @Override
    public Publicity Update(Publicity publicity) {
       return  publicityRepository.save(publicity) ;
    }

    @Override
    public List<Publicity> findAll() {
        return   publicityRepository.findAll() ;
    }

    @Override
    public Publicity findById(Long id) {
        return  publicityRepository.findById(id).get() ;
    }

    @Override
    public void deleteById(Long id) {
        publicityRepository.deleteById(id);
    }

}
