package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.model.Option;
import esprit.tn.theteam_api.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
public class OptionController {
    @Autowired
    OptionService optionService ;
    @PutMapping("/option/{idO}/{idU}")
    public boolean click (@PathVariable("idO") Long idO , @PathVariable("idU") Long  idU){
        Option option =optionService.findById(idO) ;
        System.out.println(optionService.findByIdusersSurveyId(idU,option.getSurvey().getId()));
      if(!optionService.findByIdusersSurveyId(idU,option.getSurvey().getId())){return  false ; }
        else {if(option.getIduser() == null)
        {
            ArrayList<Long> list  = new ArrayList<Long>();
            list.add(idU);
            option.setIduser(list);


        }
        else {
            option.getIduser().add(idU);

        }
        optionService.update(option);
        return  true ; }
    }
}
