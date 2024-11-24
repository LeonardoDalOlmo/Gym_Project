package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Model.Plan;
import com.example.Gym.Project.Model.Student;
import com.example.Gym.Project.Model.Subscription;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
public class SubscriptionDTO {

    private Integer subscriptionId;
    private Integer studentId;
    private Integer planId;
    private Integer modalityId;
    private Instant subscriptionStartDate;
    private Instant subscriptionEndDate;

    public void SubscriptionDTO(Integer subscriptionId, Integer studentId, Integer planId, Integer modalityId, Instant subscriptionStartDate, Instant subscriptionEndDate) {
        this.subscriptionId = subscriptionId;
        this.studentId = studentId;
        this.planId = planId;
        this.modalityId = modalityId;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public SubscriptionDTO(Subscription entity) {
        subscriptionId = entity.getSubscriptionId();
        studentId = entity.getStudentId().getStudentId();
        planId = entity.getPlanId().getPlanId();
        modalityId = entity.getModalityId().getModalityId();
        subscriptionStartDate = entity.getSubscriptionStartDate();
        subscriptionEndDate = entity.getSubscriptionEndDate();
    }

    public Instant getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public Instant getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public Integer getModalityId() {
        return modalityId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }
}
