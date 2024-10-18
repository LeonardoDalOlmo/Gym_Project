package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_subscription")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscriptionId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "planId")
    private Plan planId;

    @ManyToOne
    @JoinColumn(name = "periodId")
    private Period preiodId;

    @ManyToOne
    @JoinColumn(name = "modalityId")
    private Modality modalityId;

    private Instant subscriptionStartDate = Instant.now();
    private Instant subscriptionEndDate;
}
