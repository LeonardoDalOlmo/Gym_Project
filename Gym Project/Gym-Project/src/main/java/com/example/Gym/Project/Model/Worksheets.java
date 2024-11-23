package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Student student;

    @Column(nullable = false)
    private String worksheetDay;

    @Column(nullable = false)
    private String machineDescription;

    @Column(nullable = false)
    private Integer setNumber;

    @Column(nullable = false)
    private Integer repetitionNumber;
}
