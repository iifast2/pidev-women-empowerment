package esprit.tn.theteam_api.service;

import esprit.tn.theteam_api.model.Option;
import esprit.tn.theteam_api.model.Survey;
import esprit.tn.theteam_api.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    OptionService optionService ;
    public Survey save (Survey survey){
        List<Option> lst = new ArrayList<>();
        Survey s = surveyRepository.save(survey) ;
        if(!survey.getOptions().isEmpty()){

        for (Option o:survey.getOptions()) {
                o.setSurvey(s);
            if(o.getId() == null){
                lst.add(optionService.save(o)) ;
            }
            else{
                lst.add(optionService.update(o)) ;
            }
        }}
        s.setOptions(lst);
        return s;
    }

    public Survey findById(Long id) {
        return  surveyRepository.findById(id).get() ;
    }
    public void deletebyId(Long id){
        surveyRepository.deleteById(id);
    }



}
