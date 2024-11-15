package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Service.ModalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/modalitys")
public class ModalityController {

    @Autowired
    private ModalityService service;

    @GetMapping
    public ResponseEntity<List<ModalityDTO>> fidnAll() {
        var modalitys = service.findAll();

        return ResponseEntity.ok().body(modalitys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalityDTO> findbyId(@PathVariable Integer id) {
        var modality = service.findById(id);

        return ResponseEntity.ok().body(modality);
    }
}
