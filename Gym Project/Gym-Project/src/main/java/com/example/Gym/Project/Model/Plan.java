package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;
    @Column(nullable = false)
    private String planName;
    @Column(nullable = false)
    private String planDescription;
    @Column(nullable = false)
    private Double planPrice;

    @OneToMany(mappedBy = "planId")
    private List<Subscriptions> subscriptionsList = new ArrayList<>();
}
