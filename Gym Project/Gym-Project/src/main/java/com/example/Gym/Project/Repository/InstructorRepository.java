package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
