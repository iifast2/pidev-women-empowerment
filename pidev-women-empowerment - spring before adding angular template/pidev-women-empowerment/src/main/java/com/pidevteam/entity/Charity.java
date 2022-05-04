package com.pidevteam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idC;
    private String objective;
    //private String pictureWomen;
    //private String  statistical;
    //private String pictureTraining;
   // private Integer user_donation ;

    @ManyToOne
    private Jackpot jackpot;

}
