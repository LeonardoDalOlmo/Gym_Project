package com.example.Gym.Project.DTO;
import com.example.Gym.Project.Model.Student;
import com.example.Gym.Project.Model.StudentStatus;
import com.example.Gym.Project.Model.Worksheets;

import java.util.ArrayList;
import java.util.List;


public class StudentDTO {

    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private Integer studentPhone;
    private StudentStatus studentStatus;
    private List<WorksheetsDTO> worksheetsDTOList = new ArrayList<>();

    public StudentDTO(Integer studentId, String studentName, Integer studentAge, Integer studentPhone, StudentStatus studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
        this.studentStatus = studentStatus;
    }

    public StudentDTO(Student entity){
        studentId = entity.getStudentId();
        studentName = entity.getStudentName();
        studentAge = entity.getStudentAge();
        studentPhone = entity.getStudentPhone();
        studentStatus = entity.getStudentStatus();
        entity.getWorksheetsList().forEach(cat -> this.worksheetsDTOList.add(new WorksheetsDTO(cat)));
    }


    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public Integer getStudentPhone() {
        return studentPhone;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public List<WorksheetsDTO> getWorksheetsDTOList() {
        return worksheetsDTOList;
    }
}
