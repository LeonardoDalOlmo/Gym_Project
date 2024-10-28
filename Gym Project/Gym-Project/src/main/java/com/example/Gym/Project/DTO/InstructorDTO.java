package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Instructor;

public class InstructorDTO {

    private int instructorId;
    private String instructorName;
    private Integer instructorPhoneNumber;
    private String instructorDescription;
    private Double instructorSalary;

    public InstructorDTO(int instructorId, String instructorName, Integer instructorPhoneNumber, String instructorDescription, Double instructorSalary) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorPhoneNumber = instructorPhoneNumber;
        this.instructorDescription = instructorDescription;
        this.instructorSalary = instructorSalary;
    }

    public InstructorDTO(Instructor entity){
        instructorId = entity.getInstructorId();
        instructorName = entity.getInstructorName();
        instructorPhoneNumber = entity.getInstructorPhoneNumber();
        instructorDescription = entity.getInstructorDescription();
        instructorSalary = entity.getInstructorSalary();
        
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
}
