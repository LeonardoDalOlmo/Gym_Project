package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Days;
import com.example.Gym.Project.Model.Modality;

import java.util.ArrayList;
import java.util.List;

public class ModalityDTO {

    private Integer modalityId;
    private String modalityName;
    private String modalityDescription;
    private Days modalityDay;

    public ModalityDTO(Integer modalityId, String modalityName, String modalityDescription, Days modalityDay) {
        this.modalityId = modalityId;
        this.modalityName = modalityName;
        this.modalityDescription = modalityDescription;
        this.modalityDay = modalityDay;
    }

    public ModalityDTO(Modality entity){
        modalityId = entity.getModalityId();
        modalityName = entity.getModalityName();
        modalityDescription = entity.getModalityDescription();
        modalityDay = entity.getModalityDay();
    }


    public Integer getModalityId() {
        return modalityId;
    }

    public String getModalityName() {
        return modalityName;
    }

    public String getModalityDescription() {
        return modalityDescription;
    }

    public Days getModalityDay() {
        return modalityDay;
    }
}
