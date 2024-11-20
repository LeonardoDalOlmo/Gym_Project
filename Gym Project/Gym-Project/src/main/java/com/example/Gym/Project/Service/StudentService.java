package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.DTO.StudentDTO;
import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Repository.StudentRepository;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Gym.Project.Model.Student;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(x -> new StudentDTO(x)).toList();

    }

    @Transactional
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new StudentDTO(student);
    }

    @Transactional
    public StudentDTO insertStudent(StudentDTO dto) {
        Student student = new Student();
        copyDtoToEntity(dto, student);
        studentRepository.save(student);
        return new StudentDTO(student);
    }

    @Transactional
    public StudentDTO updateStudent(Integer id, StudentDTO dto) {
        try {
            Student student = studentRepository.getReferenceById(id);
            copyDtoToEntity(dto, student);
            student = studentRepository.save(student);
            return new StudentDTO(student);
        }
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional
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

    @Transactional
    public List<ModalityDTO> findModalitybyStudent(Integer id){
        List<Modality> modalities = studentRepository.searchModalitybyStudent(id);
        return modalities.stream().map(x -> new ModalityDTO(x)).toList();
    }

    public void copyDtoToEntity(StudentDTO dto, Student entity) {
        entity.setStudentName(dto.getStudentName());
        entity.setStudentAge(dto.getStudentAge());
        entity.setStudentPhone(dto.getStudentPhone());
        entity.setStudentStatus(dto.getStudentStatus());
    }
}
