package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.PeriodDTO;
import com.example.Gym.Project.Service.PeriodService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/periods")
public class PeriodController {

    @Autowired
    private PeriodService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<PeriodDTO>> findAll(){
        List<PeriodDTO> periods = service.findAll();

        return ResponseEntity.ok().body(periods);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PeriodDTO> findById(@PathVariable Integer id) {
        var periods = service.findById(id);

        return ResponseEntity.ok().body(periods);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PeriodDTO> insert(@RequestBody PeriodDTO dto){
        var period = service.insertPeriod(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(period.getPeriodId()).toUri();

        return ResponseEntity.created(uri).body(period);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PeriodDTO> update(@PathVariable Integer id, @RequestBody PeriodDTO dto){
        var period = service.updatePeriod(id, dto);

        return ResponseEntity.ok().body(period);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deletePeriod(id);

        return ResponseEntity.noContent().build();
    }
}
