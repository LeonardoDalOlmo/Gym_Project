package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Period;

import java.time.Instant;
import java.time.LocalDateTime;

public class PeriodDTO {
    private Integer periodId;
    private String periodName;
    private LocalDateTime periodStartHour = LocalDateTime.now();
    private LocalDateTime periodEndHour = LocalDateTime.now();

    public PeriodDTO(Integer periodId, String periodName, LocalDateTime periodStartHour, LocalDateTime periodEndHour) {
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

    public LocalDateTime getPeriodStartHour() {
        return periodStartHour;
    }

    public LocalDateTime getPeriodEndHour() {
        return periodEndHour;
    }
}
