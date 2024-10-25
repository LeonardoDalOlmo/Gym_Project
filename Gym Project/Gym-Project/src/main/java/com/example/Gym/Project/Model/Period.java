package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_period")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer periodId;
    @Column(nullable = false)
    private String periodName;
    @Column(nullable = false)
    private LocalDateTime periodStartHour;
    @Column(nullable = false)
    private LocalDateTime periodEndHour;

    @ManyToMany
    @JoinTable(
            name = "modality_period",
            joinColumns = @JoinColumn(name = "periodId"),
            inverseJoinColumns = @JoinColumn(name = "modalityId")
    )
    private List<Modality> modalityList;

}
