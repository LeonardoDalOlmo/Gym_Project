package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Plan;

public class PlanDTO {

    private Integer planId;
    private String planName;
    private String planDescription;
    private Double planPrice;

    public PlanDTO(Integer planId, String planName, String planDescription, Double planPrice) {
        this.planId = planId;
        this.planName = planName;
        this.planDescription = planDescription;
        this.planPrice = planPrice;
    }

    public PlanDTO(Plan entity){
        planId = entity.getPlanId();
        planName = entity.getPlanName();
        planDescription = entity.getPlanDescription();
        planPrice = entity.getPlanPrice();
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


}
