package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRespository extends JpaRepository<Plan, Integer> {


}
