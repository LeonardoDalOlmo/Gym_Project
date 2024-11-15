package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Service.ModalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/modalitys")
public class ModalityController {

    @Autowired
    private ModalityService service;

    @GetMapping
    public ResponseEntity<List<ModalityDTO>> findAll() {
        var modalitys = service.findAll();

        return ResponseEntity.ok().body(modalitys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalityDTO> findbyId(@PathVariable Integer id) {
        var modality = service.findById(id);

        return ResponseEntity.ok().body(modality);
    }

    @PostMapping
    public ResponseEntity<ModalityDTO> insert(@RequestBody ModalityDTO dto){
        var modality = service.insertModality(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(modality.getModalityId()).toUri();

        return ResponseEntity.created(uri).body(modality);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModalityDTO> update(@PathVariable Integer id, @RequestBody ModalityDTO dto){
        var modality = service.updateModality(id, dto);

        return ResponseEntity.ok().body(modality);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteModality(id);

        return ResponseEntity.noContent().build();
    }
}
