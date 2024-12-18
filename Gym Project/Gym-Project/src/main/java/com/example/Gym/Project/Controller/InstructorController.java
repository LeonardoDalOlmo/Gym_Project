package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Service.InstructorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<InstructorDTO>> findAll(){
        List<InstructorDTO> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<InstructorDTO> findById(@PathVariable Integer id) {
        var instructor = service.findById(id);

        return ResponseEntity.ok().body(instructor);
    }

    @GetMapping(value = "modalitys/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<Integer>> modality(@PathVariable Integer id) {
        List<Integer> modalitys = service.findModalityByInstructor(id);
        return ResponseEntity.ok().body(modalitys);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<InstructorDTO> insert(@RequestBody InstructorDTO dto){
        var instructor = service.insertInstructor(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(instructor.getInstructorId()).toUri();

        return ResponseEntity.created(uri).body(instructor);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<InstructorDTO> update(@PathVariable Integer id, @RequestBody InstructorDTO dto){
        var instructor = service.updateInstructor(id, dto);

        return ResponseEntity.ok().body(instructor);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteInstructor(id);

        return ResponseEntity.noContent().build();
    }
}
