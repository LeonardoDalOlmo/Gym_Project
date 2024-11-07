package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.StudentDTO;
import com.example.Gym.Project.Repository.StudentRepository;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Gym.Project.Model.Student;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO findAll(Integer id) {
        return (StudentDTO) studentRepository.findAll();
    }

    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new StudentDTO(student);
    }

    public StudentDTO insertStudent(StudentDTO dto) {
        Student student = new Student();
        copyDtoToEntity(dto, student);
        studentRepository.save(student);
        return new StudentDTO(student);
    }

    public StudentDTO updateStudent(Integer id, StudentDTO dto) {
        try {
            Student student = studentRepository.getReferenceById(dto.getStudentId());
            copyDtoToEntity(dto, student);
            student = studentRepository.save(student);
            return new StudentDTO(student);
        }
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    public void deleteStudent(Integer id) {
        if(!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            studentRepository.deleteById(id);
        }
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Falha ao excluir o recurso");
        }
    }

    public void copyDtoToEntity(StudentDTO dto, Student entity) {
        entity.setStudentName(dto.getStudentName());
        entity.setStudentAge(dto.getStudentAge());
        entity.setStudentPhone(dto.getStudentPhone());
        entity.setStudentStatus(dto.getStudentStatus());
    }
}
