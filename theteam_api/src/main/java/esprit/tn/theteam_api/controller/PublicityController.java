package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.model.Publication;
import esprit.tn.theteam_api.model.Publicity;
import esprit.tn.theteam_api.service.ICrudService;
import esprit.tn.theteam_api.service.PublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicity")
public class PublicityController implements ICrudService<Publicity> {
    @Autowired
    PublicityService publicityService;
    @Autowired
    Facebook facebook ;
    @PostMapping("/pub")
            public Publicity save (@RequestBody Publicity publicity ){
        //facebook.feedOperations().updateStatus(publicity.toString());
        facebook.feedOperations().updateStatus("I'm trying out Spring Social!");
        // User user = userService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName());
       // publicity.setUser(user);
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
