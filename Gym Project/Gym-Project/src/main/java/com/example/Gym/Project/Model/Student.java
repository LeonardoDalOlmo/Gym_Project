package com.example.Gym.Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private Integer studentAge;
    @Column(nullable = false)
    private Integer studentPhone;
    @Column(nullable = false)
    private StudentStatus studentStatus;

    @OneToMany(mappedBy = "studentId")
    private List<Worksheets> worksheetsList = new ArrayList<>();

    @OneToMany(mappedBy = "studentId")
    private List<Subscriptions> subscriptionList = new ArrayList<>();



}