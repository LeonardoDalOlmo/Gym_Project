package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Service.ModalityService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/modalitys")
public class ModalityController {

    @Autowired
    private ModalityService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<ModalityDTO>> fidnAll() {
        List<ModalityDTO> modalitys = service.findAll();

        return ResponseEntity.ok().body(modalitys);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ModalityDTO> findbyId(@PathVariable Integer id) {
        var modality = service.findById(id);

        return ResponseEntity.ok().body(modality);
    }

    @GetMapping(value = "/instructors/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<InstructorDTO>> findInstructor(@PathVariable Integer id) {
        var instructors = service.findInstructorByModality(id);
        return ResponseEntity.ok().body(instructors);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ModalityDTO> insert(@RequestBody ModalityDTO dto) {
        var modality = service.insertModality(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(modality.getModalityId()).toUri();

        return ResponseEntity.created(uri).body(modality);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ModalityDTO> update(@PathVariable Integer id,@RequestBody ModalityDTO dto) {
        var modality = service.updateModality(id, dto);

        return ResponseEntity.ok().body(modality);
    }
    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<ModalityDTO> delete(@PathVariable Integer id) {
        service.deleteModality(id);
        return ResponseEntity.noContent().build();
    }
}
