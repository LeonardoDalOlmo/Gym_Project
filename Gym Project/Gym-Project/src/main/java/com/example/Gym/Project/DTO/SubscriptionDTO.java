package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Model.Period;
import com.example.Gym.Project.Model.Plan;
import com.example.Gym.Project.Model.Student;
import com.example.Gym.Project.Model.Subscription;

import java.time.Instant;


public class SubscriptionDTO {

    private Integer subscriptionId;
    private Student studentId;
    private Plan planId;
    private Period periodId;
    private Modality modalityId;
    private Instant subscriptionStartDate;
    private Instant subscriptionEndDate;

    public void SubscriptionDTO(Integer subscriptionId, Student studentId, Plan planId, Period periodId, Modality modalityId, Instant subscriptionStartDate, Instant subscriptionEndDate) {
        this.subscriptionId = subscriptionId;
        this.studentId = studentId;
        this.planId = planId;
        this.periodId = periodId;
        this.modalityId = modalityId;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public SubscriptionDTO(Subscription entity) {
        subscriptionId = entity.getSubscriptionId();
        studentId = entity.getStudentId();
        planId = entity.getPlanId();
        periodId = entity.getPreiodId();
        modalityId = entity.getModalityId();
        subscriptionStartDate = entity.getSubscriptionStartDate();
        subscriptionEndDate = entity.getSubscriptionEndDate();
    }

    public Instant getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public Instant getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public Modality getModalityId() {
        return modalityId;
    }

    public Period getPeriodId() {
        return periodId;
    }

    public Plan getPlanId() {
        return planId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }
}