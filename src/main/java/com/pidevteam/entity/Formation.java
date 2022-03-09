package com.pidevteam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String nom;
    Integer nombreParticipant;


    @OneToMany(mappedBy = "formation",cascade = CascadeType.REMOVE)
    List<File > files;

    @OneToOne()
    Quiz quiz ;
//
//    @OneToMany(mappedBy = "formation", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
//    List<Certificat> certificats;

    @ManyToMany ()
    //hethi  zdtha ena
    @JoinTable(name = "USER_formation", joinColumns = {
            @JoinColumn(name = "Formation_ID") }, inverseJoinColumns = {
              @JoinColumn(name = "USER_ID")})
    List<User> user;
}
