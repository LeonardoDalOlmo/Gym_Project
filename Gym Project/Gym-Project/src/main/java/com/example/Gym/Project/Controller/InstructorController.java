package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> findAll(){
        var instructors = service.findAll();

        return ResponseEntity.ok().body(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTO> findById(@PathVariable Integer id) {
        var instructor = service.findById(id);

        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping
    public ResponseEntity<InstructorDTO> insert(@RequestBody InstructorDTO dto){
        var instructor = service.insertInstructor(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(instructor.getInstructorId()).toUri();

        return ResponseEntity.created(uri).body(instructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorDTO> update(@PathVariable Integer id, @RequestBody InstructorDTO dto){
        var instructor = service.updateInstructor(id, dto);

        return ResponseEntity.ok().body(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteInstructor(id);

        return ResponseEntity.noContent().build();
    }
}
