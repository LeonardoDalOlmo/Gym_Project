package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;

import java.util.ArrayList;
import java.util.List;

public class InstructorDTO {

    private int instructorId;
    private String instructorName;
    private Integer instructorPhoneNumber;
    private String instructorDescription;
    private Double instructorSalary;
    private List<ModalityDTO> modalityList = new ArrayList<>();

    public InstructorDTO(int instructorId, String instructorName, Integer instructorPhoneNumber, String instructorDescription, Double instructorSalary, List<ModalityDTO> modalityList) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorPhoneNumber = instructorPhoneNumber;
        this.instructorDescription = instructorDescription;
        this.instructorSalary = instructorSalary;
        this.modalityList = modalityList;
    }

    public InstructorDTO(Instructor entity){
        instructorId = entity.getInstructorId();
        instructorName = entity.getInstructorName();
        instructorPhoneNumber = entity.getInstructorPhoneNumber();
        instructorDescription = entity.getInstructorDescription();
        instructorSalary = entity.getInstructorSalary();
        entity.getModalityList().forEach(cat -> this.modalityList.add(new ModalityDTO(cat)));
        
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public Integer getInstructorPhoneNumber() {
        return instructorPhoneNumber;
    }

    public String getInstructorDescription() {
        return instructorDescription;
    }

    public Double getInstructorSalary() {
        return instructorSalary;
    }

    public List<ModalityDTO> getModalityList() {
        return modalityList;
    }
}
