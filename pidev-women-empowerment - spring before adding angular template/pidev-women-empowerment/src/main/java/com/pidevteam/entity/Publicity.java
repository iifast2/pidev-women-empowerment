package com.pidevteam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Publicity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name ;
    @Temporal(TemporalType.DATE)
    Date dateStart ;
    @Temporal(TemporalType.DATE)
    Date dateEnd  ;
    int nbInitTarget ;
    int  nbFinalViews ;
    double  cost ;
    String type ;
    String canal ;
    String nameFile ;
    int ageDebut ;
    int ageFin ;
    Domain domain ;
    @ManyToOne()
    User user ;

    public Publicity(String name, Date dateStart, Date dateEnd, int nbInitTarget, int nbFinalViews, double cost, String type, String canal, int ageDebut, int ageFin, Domain domain) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.nbInitTarget = nbInitTarget;
        this.nbFinalViews = nbFinalViews;
        this.cost = cost;
        this.type = type;
        this.canal = canal;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
        this.domain = domain;
    }

    public Publicity(String name, Domain domain, Date dateDeb, Date dateFin, int nbVueCible, int nbVueFinal, int ageDebut, int ageFin, Double cost) {
    }
}
