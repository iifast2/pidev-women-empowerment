package com.pidevteam.service;

import com.pidevteam.entity.*;
import com.pidevteam.repository.DonationuserRepository;
import com.pidevteam.repository.JackpotRepository;
import com.pidevteam.repository.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class JackpotService implements JackpotServiceInt{
    @Autowired
    DonationuserRepository dr;
    @Autowired
    JackpotRepository repository;
    @Autowired
    ParametersRepository pr;
    @Override
    public Integer saveJackpot(Jackpot jackpot) {
        return repository.save(jackpot).getIdJ();
    }

    @Override
    public List<Jackpot> getAllJackpots() {
        return (List<Jackpot>) repository.findAll();
    }

    @Override
    public Jackpot getJackpotById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteJackpot(Integer id) {
        repository.deleteById(id);

    }
    @Override
    public int calculerscore (Donationuser u) {
        int score = 0 ;

        Parameters p= pr.findById(1).orElse(null);
        if (u.getUnemployed().equals("yes"))
        {score = score + p.getUnemployed();
        }

        if ( u.getSocialNeed().equals("yes"))
        {
            score = score + p.getSocialNeed();

        }
        if (u.getMedicalNeed().equals("yes"))
        {
            score = score + p.getMedicalNeed();
        }
        if (u.getNeedy().equals("yes"))
        {
            score = score + p.getNeedy();
        }
        if ( u .getNbPersFamily() == 4 )
        {score = score + p.getNbPersFamily_4();
        }
        if ( u .getNbPersFamily() >= 5 )
        {score = score + p.getNbPersFamily_5();
        }
        if ( u.getMonthlyincome() <= 420 )
        {
            score = score + p.getMonthlyincome_420();
        }
        if ((  u.getMonthlyincome() <= 800) && (u.getMonthlyincome() >= 420))
        {
            score = score + p.getMonthlyincome_800();
        }
        if ( u.getNbStudentsInFamily() == 1)
        {
            score =score+ p.getNbStudentsInFamily_1();
        }
        if ( u.getNbStudentsInFamily() == 2)
        {
            score =score+ p.getNbStudentsInFamily_2();
        }
        if ( u.getNbStudentsInFamily() == 3)
        {
            score =score+ p.getNbStudentsInFamily_3();
        }
        if ( u.getAmoutwon() != 0)
        {
            score = score - p.getAlreadywon();
        }

        return score;
    }


    /*
    @Override
    public Jackpot UpdateJacpot (Jackpot j , Integer idJ) {
        // TODO Auto-generated method stub
        j.setIdJ(idJ);
        return repository.save(j);
    }*/


    @Override
    public List<Jackpot> jackpotencrs() {
        List <Jackpot> j = new ArrayList<>();
        for (Jackpot jp:repository.findAll())
        {
            if (jp.getEtat_J()== Etat_J.ENCOURS)
            {
                j.add(jp);
            }
        }
        return j;
    }
    @Override
    public Map<Integer, Integer> afficherlisteneedy() {
        Map<Integer, Integer> Listdonation = new HashMap<Integer, Integer>();

        for (Donationuser u:dr.findAll())
        {
            Listdonation.put(u.getId(),calculerscore(u));
        }


        Map<Integer, Integer> result = Listdonation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }

    @Override
    public Map<Integer, Integer> attribuerjackpot(int i) {
        Map<Integer, Integer> Listdonation = afficherlisteneedy();
        Map<Integer, Integer> Listeargent =  new HashMap<Integer, Integer>();
        Jackpot j=repository.findById(i).orElse(null);
         int amount = j.getAmount();

        for (Integer key : Listdonation.keySet()) {
            //mapentry.getKey()
            // mapentry.getValue());
            Donationuser d = dr.findById(key).orElse(null);
            double a =amount * 0.25;
            if (amount > 0)
            {
                d.setAmoutwon(a);
                amount = (int) (amount - a) ;
            }
            dr.save(d);

            Listeargent.put(key, (int) a);
        }
        j.setEtat_J(Etat_J.FINIS);
        repository.save(j);
        return Listeargent;
    }

}
