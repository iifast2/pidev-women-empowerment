package com.women.spring.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "Evaluation")
public class Evaluation {

    @Id
    @Column(name = "RATING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @NotNull(message = "The user id provided is either empty or null")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @NotNull(message = "The Training id provided is either empty or null")
    @JoinColumn(name = "formation_id")
    Formation formation;

    @Column(name = "RATING")
    @Min(value = 1, message = "Please enter a rating greater than 0")
    @Max(value = 10, message = "Please enter a rating lesser than 10")
    int rating;

}

