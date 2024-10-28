package com.example.Gym.Project.Service;

import com.example.Gym.Project.Model.Plan;
import com.example.Gym.Project.Repository.PlanRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    @Autowired
    private PlanRespository repository;



}
