package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.WorksheetsDTO;
import com.example.Gym.Project.Service.WorksheetsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/worksheets")
public class WorksheetsController {

    @Autowired
    private WorksheetsService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<WorksheetsDTO>> findAll(){
        var worksheets = service.findAll();

        return ResponseEntity.ok().body(worksheets);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<WorksheetsDTO> findById(@PathVariable Integer id) {
        var worksheets = service.findById(id);

        return ResponseEntity.ok().body(worksheets);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<WorksheetsDTO> insert(@RequestBody WorksheetsDTO dto){
        var worksheet = service.insertWorksheet(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(worksheet.getWorksheetId()).toUri();

        return ResponseEntity.created(uri).body(worksheet);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<WorksheetsDTO> update(@PathVariable Integer id, @RequestBody WorksheetsDTO dto){
        var instructor = service.updateWorksheet(id, dto);

        return ResponseEntity.ok().body(instructor);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteWorksheet(id);

        return ResponseEntity.noContent().build();
    }

}
