package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructorId;
    @Column(nullable = false)
    private String instructorName;
    @Column( nullable = false)
    private Integer instructorPhoneNumber;
    @Column(nullable = false)
    private String instructorDescription;
    @Column(nullable = false)
    private Double instructorSalary;


    @ManyToMany
    @JoinTable(
            name = "modality_instructor",
            joinColumns = @JoinColumn(name = "instructorId"),
            inverseJoinColumns = @JoinColumn(name = "modalityId")
    )
    private List<Modality> modalityList;
}
