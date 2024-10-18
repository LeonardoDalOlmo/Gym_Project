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
    @Column(length = 100, nullable = false)
    private String instructorName;
    @Column(length = 15)
    private Integer instructorPhoneNumber;
    @Column(length = 150)
    private String instructorDescription;

    @ManyToMany
    @JoinTable(
            name = "modality_instructor",
            joinColumns = @JoinColumn(name = "instructorId"),
            inverseJoinColumns = @JoinColumn(name = "modalityId")
    )
    private List<Modality> modalityList;
}
