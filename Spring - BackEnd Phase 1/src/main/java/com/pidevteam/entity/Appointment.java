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
public class Appointment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String title;
     Date date;
     @ManyToOne()
     User user ;
}
