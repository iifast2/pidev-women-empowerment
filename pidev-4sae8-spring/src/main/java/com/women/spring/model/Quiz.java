package com.women.spring.model;

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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title ;
    int note;

    @OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("quiz")
    List<Question> questions ;

    @OneToOne()
    Formation formation ;


}
