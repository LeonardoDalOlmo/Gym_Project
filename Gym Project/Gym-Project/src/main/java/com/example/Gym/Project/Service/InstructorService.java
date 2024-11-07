package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Repository.InstructorRepository;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorDTO findById(Integer id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new InstructorDTO(instructor);
    }

    public InstructorDTO findAll(InstructorDTO instructorDTO) {
        return (InstructorDTO) instructorRepository.findAll();
    }

    public InstructorDTO insertInstructor(InstructorDTO dto) {
        Instructor instructor = new Instructor();
        copyDtoToEntity(dto, instructor);
        instructorRepository.save(instructor);
        return new InstructorDTO(instructor);
    }

    public void copyDtoToEntity(InstructorDTO dto, Instructor entity) {
        entity.setInstructorName(dto.getInstructorName());
        entity.setInstructorPhoneNumber(dto.getInstructorPhoneNumber());
        entity.setInstructorDescription(dto.getInstructorDescription());
        entity.setInstructorSalary(dto.getInstructorSalary());
    }
}
