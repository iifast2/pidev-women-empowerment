package com.pidevteam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

