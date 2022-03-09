package com.pidevteam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String question ;
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("survey")
    List<Option> options;
   /* @OneToOne()

    Publication publication ;*/
}
