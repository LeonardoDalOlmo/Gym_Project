package com.example.Gym.Project.DTO;

import com.example.Gym.Project.Model.Student;
import com.example.Gym.Project.Model.Worksheets;

public class WorksheetsDTO {

    private int worksheetId;
    private Integer studentId;
    private String worksheetDay;
    private String machineDescription;
    private Integer setNumber;
    private Integer repetitionNumber;

    public WorksheetsDTO(int worksheetId, Integer studentId, String worksheetDay, String machineDescription, Integer setNumber, Integer repetitionNumber) {
        this.worksheetId = worksheetId;
        this.studentId = studentId;
        this.worksheetDay = worksheetDay;
        this.machineDescription = machineDescription;
        this.setNumber = setNumber;
        this.repetitionNumber = repetitionNumber;
    }

    public WorksheetsDTO(Worksheets entity) {
        worksheetId = entity.getWorksheetId();
        studentId = entity.getStudent().getStudentId();
        worksheetDay = entity.getWorksheetDay();
        machineDescription = entity.getMachineDescription();
        setNumber = entity.getSetNumber();
        repetitionNumber = entity.getRepetitionNumber();
    }

    public int getWorksheetId() {
        return worksheetId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getWorksheetDay() {
        return worksheetDay;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public Integer getRepetitionNumber() {
        return repetitionNumber;
    }
}
