package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.model.Publication;
import esprit.tn.theteam_api.service.ICrudService;
import esprit.tn.theteam_api.service.OptionService;
import esprit.tn.theteam_api.service.PublicationService;
import esprit.tn.theteam_api.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController implements ICrudService<Publication> {
    @Autowired
    PublicationService publicationService;
    @Autowired
    SurveyService surveyService ;

    @PostMapping()
            public Publication save (@RequestBody Publication publication ){
        if(publication.getSurvey() != null ){
            if(publication.getSurvey().getId() == null){
                publication.setSurvey(surveyService.save(publication.getSurvey()));
            }
        }
        publication.setDateCreation(new Date());
        return publicationService.save(publication);
    }

    @PutMapping()
    public Publication Update(Publication publication) {
       //if() {  User user = userService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName());
        Publication publication1 = findById(publication.getId()) ;
        if(publication == null){
            if(publication1.getSurvey() != null)
            surveyService.deletebyId(publication1.getSurvey().getId());
        }
        else {
           publication.setSurvey(surveyService.save(publication.getSurvey()));
        }

            return     publicationService.Update(publication);
       // return true  ;
    //}
    }

    @GetMapping()
    public List<Publication> findAll() {
        return publicationService.findAll() ;
    }

    @GetMapping("/{id}")
    public Publication findById(@PathVariable("id") Long id) {
       return publicationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
    publicationService.deleteById(id);
    }

    @GetMapping("/newpublication")
    public List<Publication> findAllByDateCreation() {
        return publicationService.findAllByDateCreation() ;

    }
    @GetMapping("/filter")
    public List<Publication> filter(@RequestBody Publication p ){
        //List<Publication> lst = new ArrayList<>();
        return  publicationService.filter(p);
    }
}
