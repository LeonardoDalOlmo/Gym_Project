package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.DTO.StudentDTO;
import com.example.Gym.Project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        var students = service.findAll();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) {
        var student = service.findById(id);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("modalitys/{id}")
    public ResponseEntity<List<ModalityDTO>> modality(@PathVariable Integer id) {
        var modalitys = service.findModalitybyStudent(id);
        return ResponseEntity.ok().body(modalitys);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO dto){
        var student = service.insertStudent(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(student.getStudentId()).toUri();

        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Integer id, @RequestBody StudentDTO dto){
        var student = service.updateStudent(id, dto);

        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

}
