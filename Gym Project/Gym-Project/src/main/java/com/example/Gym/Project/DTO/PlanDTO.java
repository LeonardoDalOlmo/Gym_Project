package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Plan;

import java.time.LocalDateTime;

public class PlanDTO {

    private Integer planId;
    private String planName;
    private String planDescription;
    private Double planPrice;
    private LocalDateTime planStart = LocalDateTime.now();
    private LocalDateTime planEnd = LocalDateTime.now();

    public PlanDTO(Integer planId, String planName, String planDescription, Double planPrice, LocalDateTime planStart, LocalDateTime planEnd) {
        this.planId = planId;
        this.planName = planName;
        this.planDescription = planDescription;
        this.planPrice = planPrice;
        this.planStart = planStart;
        this.planEnd = planEnd;
    }

    public PlanDTO(Plan entity){
        planId = entity.getPlanId();
        planName = entity.getPlanName();
        planDescription = entity.getPlanDescription();
        planPrice = entity.getPlanPrice();
        planStart = entity.getPlanStart();
        planEnd = entity.getPlanEnd();
    }

    public Integer getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public Double getPlanPrice() {
        return planPrice;
    }

    public LocalDateTime getPlanStart() {
        return planStart;
    }

    public LocalDateTime getPlanEnd() {
        return planEnd;
    }
}
