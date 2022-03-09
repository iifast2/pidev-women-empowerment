package com.pidevteam.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
    private Integer idSubscription;

    //  @Column(name = "USER_NAME")
    @Size(min = 2, max = 20)
    private String title;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    @Temporal(TemporalType.DATE)
    private Date datedebut;
    private Date datefin;




    @OneToMany(mappedBy = "subscriptions")
    List<User> users;



    /////////////////////////////


    public Subscription() {
        super();
    }






    public Subscription(Integer idSubscription, String title, Niveau niveau, Date datedebut, Date datefin) {
        super();
        this.idSubscription = idSubscription;
        this.title = title;
        this.niveau = niveau;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }



    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }


}