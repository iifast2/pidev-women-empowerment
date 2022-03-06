package esprit.tn.theteam_api.service;

import esprit.tn.theteam_api.model.Option;

import esprit.tn.theteam_api.repository.OptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {


    @Autowired
    OptionRepository optionRepository;
    public Option save (Option option){
        return optionRepository.save(option) ;
    }
    public Option update (Option option){
        return optionRepository.save(option) ;
    }

    public Option findById(Long id) {
        return  optionRepository.findById(id).get() ;
    }

    public boolean findByIdusersSurveyId(Long idU, Long idS){

        List<Option>  op =optionRepository.findAllBySurveyId(idS);
        for (Option o: op ) {
            if(o.getIduser() != null ){
            if(o.getIduser().contains(idU)) return  false ;}

        }
        return  true ;
    }

}
