package com.pidevteam.controller;

import com.pidevteam.entity.Domain;
import com.pidevteam.entity.Publicity;
import com.pidevteam.service.FileStorageService;
import com.pidevteam.service.PublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publicity")
public class PublicityController  {
    @Autowired
    PublicityService publicityService;
//    @Autowired
//    Facebook facebook ;
@Autowired
FileStorageService fileStorageService;
    @PostMapping("/pub")

            public Publicity save (
                    @RequestParam ("name") String name, @RequestParam ("domain") Domain domain,
                              //     @RequestParam ("dateDeb") Date dateDeb, @RequestParam ("dateFin") Date dateFin,
                                   @RequestParam ("nbVueCible") int nbVueCible, @RequestParam ("nbVueFinal") int nbVueFinal,
                                   @RequestParam ("ageDebut") int ageDebut, @RequestParam ("ageFin") int ageFin
            ,@RequestParam ("cost") Double  cost, @RequestParam("upload") MultipartFile upload

//            @RequestBody Publicity publicity
    ) {

        Facebook facebook = new FacebookTemplate("EAAGy7q7ydyoBAEipZANrHgfr8o5XJcWAOxtyPCmd9qfpOOZCiHmUUyWQkQTZCkc6bKM0tZCi4RaMAWfghyUC6LWgV34ZCU5ZCtN3X7drvMwkk6KE5TjvDyZC2hP6V2wtDs2Hv1FjO8pbHh90VKVP1UkSqS4ZCyFxCHxakIBz7n4DfAfAAhOoiQcz4ZClJXpZCzUJEv5qLXlTC69m2ncdM8cvgA");
       Publicity publicity = new Publicity(name ,domain ,new Date() ,new Date(), nbVueCible,nbVueFinal ,ageDebut ,ageFin,cost) ;
       publicity.setNameFile(fileStorageService.storeFile(upload));
       if(facebook.isAuthorized()){
//           PostData link= new PostData("5");
//           link.("",publicity.getNameFile(),publicity.getName(),publicity.getDomain().toString(),"the team pu"+publicity.getName());
//        facebook.feedOperations().post(link);
//           FacebookLink facebookLink = new FacebookLink("https://i.imgur.com/7s5Jv7k.png","","","");
//           FacebookLink link = new FacebookLink("http://jeromejaglale.com/",
//                   "Spring is easy with Spring Cookbook",
//                   "Spring Cookbook",
//                   "The recipes are understandable and actually work.");


           String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                   .path("/downloadFile/")
                   .path(publicity.getNameFile())
                   .toUriString();


//            FacebookLink facebookLink = new FacebookLink(fileDownloadUri,upload.getOriginalFilename(),publicity.getName()+" ",upload.getResource().getDescription());
         //  facebook.feedOperations().post("102343842406978",publicity.getName() );


        facebook.feedOperations().updateStatus(publicity.getName()+"\nhttps://i.imgur.com/7s5Jv7k.png") ;
        }

        return publicityService.save(publicity);
    }

    @PutMapping()
    public Publicity Update(Publicity publicity) {
       //if() {  User user = userService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName());


            return     publicityService.Update(publicity);
       // return true  ;
    //}
    }

    @GetMapping()
    public List<Publicity> findAll() {
        return publicityService.findAll() ;
    }

    @GetMapping("/{id}")
    public Publicity findById(@PathVariable("id") Long id) {
       return publicityService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
    publicityService.deleteById(id);
    }


}
