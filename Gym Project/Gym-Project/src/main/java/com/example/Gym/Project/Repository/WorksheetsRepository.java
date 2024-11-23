package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Worksheets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorksheetsRepository extends JpaRepository<Worksheets, Integer> {
}
