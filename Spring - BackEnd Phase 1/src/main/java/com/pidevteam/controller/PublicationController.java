package com.pidevteam.controller;

import com.pidevteam.entity.Publication;
import com.pidevteam.service.ICrudService;
import com.pidevteam.service.NotificationService;
import com.pidevteam.service.PublicationService;
import com.pidevteam.service.SurveyService;
import com.pidevteam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    UserServiceImpl userService ;
    @Autowired
    NotificationService notificationService ;
    @PostMapping()
            public Publication save (@RequestBody Publication publication ){
        if(publication.getSurvey() != null ){
            if(publication.getSurvey().getId() == null){
                publication.setSurvey(surveyService.save(publication.getSurvey()));
            }
        }
       publication.setUser(userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName()));
        publication.setDateCreation(new Date());
        Publication p= publicationService.save(publication);
        notificationService.notIdUserIdentification(p.getIdUserIden(),"http://localhost:8080/publication"+p.getId(),"you are identifie in publication" , "add publication ");
        return  p ;
    }

    @PutMapping()
    public Publication Update(@RequestBody Publication publication) {
       //if() {  User user = userService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(publication.getId());
        Publication publication1 = publicationService.findById(publication.getId()) ;
        if(publication == null){
            if(publication1.getSurvey() != null)
            surveyService.deletebyId(publication1.getSurvey().getId());
        }
        else {
            if(publication.getSurvey() != null){
           publication.setSurvey(surveyService.save(publication.getSurvey()));
        }}
        publication.setUser(userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName()));

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
