package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.DTO.StudentDTO;
import com.example.Gym.Project.Service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<StudentDTO>> findAll(){
        List<StudentDTO> students = service.findAll();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) {
        var student = service.findById(id);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "modalitys/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<ModalityDTO>> modality(@PathVariable Integer id) {
        var modalitys = service.findModalitybyStudent(id);
        return ResponseEntity.ok().body(modalitys);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO dto){
        var student = service.insertStudent(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(student.getStudentId()).toUri();

        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<StudentDTO> update(@PathVariable Integer id, @RequestBody StudentDTO dto){
        var student = service.updateStudent(id, dto);

        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

}
