package com.pidevteam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String comment ;
    int iduser ;
    @ManyToOne()
     @JsonIgnoreProperties({"comments","survey","user","resources","ratings"})
    Publication publication ;

    ArrayList<String> sous_comments = new ArrayList<>()  ;
    ArrayList<Long> idUserIden = new ArrayList<>() ;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("comment")
    List<Estimation> estimations ;


}
