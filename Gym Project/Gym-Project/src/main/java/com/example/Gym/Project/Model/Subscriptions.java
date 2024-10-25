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

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "planId")
    private Plan planId;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "periodId")
    private Period preiodId;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "modalityId")
    private Modality modalityId;

    @Column(nullable = false)
    private Instant subscriptionStartDate = Instant.now();

    @Column(nullable = false)
    private Instant subscriptionEndDate;
}
