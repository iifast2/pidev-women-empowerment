package com.pidevteam.service;



import com.pidevteam.entity.Donationuser;
import com.pidevteam.entity.Jackpot;

import java.util.List;
import java.util.Map;

public interface JackpotServiceInt {
    public Integer saveJackpot(Jackpot jackpot);
    public List<Jackpot> getAllJackpots();

    public Jackpot getJackpotById(Integer id);
    public void deleteJackpot(Integer id);
   // public Jackpot UpdateJacpot (Jackpot j , Integer idJ);
    public int calculerscore(Donationuser u);
    public List<Jackpot> jackpotencrs();
    public Map<Integer, Integer> afficherlisteneedy();
    public Map<Integer, Integer> attribuerjackpot(int i);
}
