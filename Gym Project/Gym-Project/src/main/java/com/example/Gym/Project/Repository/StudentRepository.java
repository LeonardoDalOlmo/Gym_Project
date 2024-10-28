package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
