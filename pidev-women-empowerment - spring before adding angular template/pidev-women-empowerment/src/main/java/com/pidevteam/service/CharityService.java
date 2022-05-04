package com.pidevteam.service;

import com.pidevteam.entity.Charity;
import com.pidevteam.entity.Formation;
import com.pidevteam.entity.goals_F;
import com.pidevteam.repository.CharityRepository;
import com.pidevteam.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharityService implements CharityServiceInt{
    @Autowired
    private CharityRepository repository;
    @Autowired
    private FormationRepository formation;
    @Override
    public Integer saveCharity(Charity charity) {
        return repository.save(charity).getIdC();
    }

    @Override
    public List<Charity> getAllCharity() {
        return (List<Charity>) repository.findAll();
    }

    @Override
    public Charity getCharityById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteCharity(Integer id) {
        repository.deleteById(id);

    }
   // @Override
    //public void updateCharity(Integer id) {
       // repository.findById(id).get();

    //}

    @Override
    public Charity UpdateCharity (Charity c ,  Integer idC){
        // TODO Auto-generated method stub
        c.setIdC(idC);
        return repository.save(c);
    }


    public ResponseEntity<String> statistiqueGoals(){
        float dipl=0.0f;
        float en_cours=0.0f;
        float All=0.0f;
        float dip_projet=0.0f;

        float pourcentage_dip=0.0f;
        //float pourcentage_proj=0;
        //  float pourcentage_en_cour=0;
        //List<Formation> fr= formation.findAll();
        for (Formation fr:formation.findAll()) {
            if (fr.getGoals_f().equals(goals_F.diplomed)) {
                dipl++;
            } else if (fr.getGoals_f().equals(goals_F.diplomed_with_project)) {
                dip_projet++;
            } else if (fr.getGoals_f().equals(goals_F.In_progress)) {
                en_cours++;
            }
            All = dipl + dip_projet + en_cours;


        }
         pourcentage_dip = (dipl / All) * 100;
        float pourcentage_proj = (dip_projet / All) * 100;
        float pourcentage_en_cour = (en_cours / All) * 100;
             return new ResponseEntity<String>("women with diplome and project  "+pourcentage_proj+

                  "\n women with diplom "+pourcentage_dip+ "\n in progress diplom  " +pourcentage_en_cour, HttpStatus.OK);

         //return pourcentage_proj;

    }
}
