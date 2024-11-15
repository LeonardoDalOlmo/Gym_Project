package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Repository.InstructorRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorDTO findById(Integer id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new InstructorDTO(instructor);
    }

    public List<ModalityDTO> findModality(Integer id){
        var instructors = instructorRepository.searchModalitybyInstructor(id);
        return instructors.stream().map(x -> new ModalityDTO(x)).toList();
    }

    public List<InstructorDTO> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructors.stream().map(x -> new InstructorDTO(x)).toList();
    }

    public InstructorDTO insertInstructor(InstructorDTO dto) {
        Instructor instructor = new Instructor();
        copyDtoToEntity(dto, instructor);
        instructorRepository.save(instructor);
        return new InstructorDTO(instructor);
    }

    public InstructorDTO updateInstructor(Integer id, InstructorDTO dto){
        try{
            Instructor instructor = instructorRepository.getReferenceById(dto.getInstructorId());
            copyDtoToEntity(dto,instructor);
            instructor = instructorRepository.save(instructor);
            return new InstructorDTO(instructor);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public void deleteInstructor(Integer id){
        if(!instructorRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            instructorRepository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw new DataBaseException("Failed to delete resource");
        }
    }

    public List<ModalityDTO> findModalityByInstructor(Integer id){
        List<Modality> modalities = instructorRepository.searchModalitybyInstructor(id);

        return modalities.stream().map(x -> new ModalityDTO(x)).toList();
    }

    public void copyDtoToEntity(InstructorDTO dto, Instructor entity) {
        entity.setInstructorName(dto.getInstructorName());
        entity.setInstructorPhoneNumber(dto.getInstructorPhoneNumber());
        entity.setInstructorDescription(dto.getInstructorDescription());
        entity.setInstructorSalary(dto.getInstructorSalary());
    }
}
