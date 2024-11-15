package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.WorksheetsDTO;
import com.example.Gym.Project.Service.WorksheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class WorksheetsController {

    @Autowired
    private WorksheetsService service;

    @GetMapping
    public ResponseEntity<List<WorksheetsDTO>> findAll(){
        var worksheets = service.findAll();

        return ResponseEntity.ok().body(worksheets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorksheetsDTO> findById(@PathVariable Integer id) {
        var worksheets = service.findById(id);

        return ResponseEntity.ok().body(worksheets);
    }

    @PostMapping
    public ResponseEntity<WorksheetsDTO> insert(@RequestBody WorksheetsDTO dto){
        var worksheet = service.insertWorksheet(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(worksheet.getWorksheetId()).toUri();

        return ResponseEntity.created(uri).body(worksheet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorksheetsDTO> update(@PathVariable Integer id, @RequestBody WorksheetsDTO dto){
        var instructor = service.updateWorksheet(id, dto);

        return ResponseEntity.ok().body(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteWorksheet(id);

        return ResponseEntity.noContent().build();
    }

}
