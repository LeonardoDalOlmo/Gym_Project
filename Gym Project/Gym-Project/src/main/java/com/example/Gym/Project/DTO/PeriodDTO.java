package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Period;

import java.time.Instant;

public class PeriodDTO {
    private Integer periodId;
    private String periodName;
    private Instant periodStartHour;
    private Instant periodEndHour;

    public PeriodDTO(Integer periodId, String periodName, Instant periodStartHour, Instant periodEndHour) {
        this.periodId = periodId;
        this.periodName = periodName;
        this.periodStartHour = periodStartHour;
        this.periodEndHour = periodEndHour;
    }

    public PeriodDTO(Period entity){
        periodId = entity.getPeriodId();
        periodName = entity.getPeriodName();
        periodStartHour = entity.getPeriodStartHour();
        periodEndHour = entity.getPeriodEndHour();
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public Instant getPeriodStartHour() {
        return periodStartHour;
    }

    public Instant getPeriodEndHour() {
        return periodEndHour;
    }
}
