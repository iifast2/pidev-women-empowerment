package com.women.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity

public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idE ;
    private String nom;
    private String description;
    private String image;
    private Date dateD;
    private Date dateF;
    private String localisation;
    private String map;
    private Float tarif;
    private Integer nbreDePlaces;
    private Etat etat;
    private Type type;

    @OneToOne(mappedBy = "events")
    private Jackpot jackpot;



}
