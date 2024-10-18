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
    private String modalityName;
    private String modalityDescription;
    private String modalityDay;

    @OneToMany(mappedBy = "modalityId")
    private List<Subscriptions> subscriptionsList = new ArrayList<>();

    @ManyToMany(mappedBy = "modalityList")
    private List<Period> periodList;

    @ManyToMany(mappedBy = "modalityList")
    private List<Instructor> instructorList;

}
