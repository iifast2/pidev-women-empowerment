package esprit.tn.theteam_api.service;

import esprit.tn.theteam_api.model.Resource;
import esprit.tn.theteam_api.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {
    private final ResourceRepository resourceRepository;

    public RessourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }


    public Resource save(Resource resource){

        return resourceRepository.save(resource);
    }

    public Resource findById(Long id){

        return resourceRepository.findById(id).isPresent() ? resourceRepository.findById(id).get() : null;
    }

    public List<Resource> findAll(){

        return resourceRepository.findAll();
    }

    public void delete(Long id){
        resourceRepository.deleteById(id);
    }
}
