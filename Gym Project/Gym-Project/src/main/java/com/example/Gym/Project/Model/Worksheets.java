package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_worksheet")
public class Worksheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer worksheetId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @Column(nullable = false)
    private LocalDate worksheetDay;

    @Column(nullable = false)
    private String machineDescription;

    @Column(nullable = false)
    private Integer setNumber;

    @Column(nullable = false)
    private Integer repetitionNumber;
}
