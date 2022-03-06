package com.women.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom ;
    String prenom;
    String email;
    Etat etat;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    List<Certificat> certificats;


    @ManyToMany (mappedBy = "user")
    List<Formation> formations;
}
