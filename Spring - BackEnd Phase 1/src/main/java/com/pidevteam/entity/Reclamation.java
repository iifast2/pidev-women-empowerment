package com.pidevteam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String subject;
     String description;
    @Enumerated(EnumType.STRING)
     Status status;
     Date date;
    @Enumerated(EnumType.STRING)
     Categories categories;
    @ManyToOne()
    User user ;

}
