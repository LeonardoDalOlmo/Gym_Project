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
@Table(name = "tb_modality")
public class Modality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modalityId;
    @Column(nullable = false)
    private String modalityName;
    @Column(nullable = false)
    private String modalityDescription;
    @Column(nullable = false)
    private List<Days> modalityDay;

    @OneToMany(mappedBy = "modalityId")
    private List<Subscription> subscriptionsList = new ArrayList<>();

    @ManyToMany(mappedBy = "modalityList")
    private List<Period> periodList;

    @ManyToMany(mappedBy = "modalityList")
    private List<Instructor> instructorList;

}
