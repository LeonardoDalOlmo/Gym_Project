package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.PeriodDTO;
import com.example.Gym.Project.Service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/periods")
public class PeriodController {

    @Autowired
    private PeriodService service;

    @GetMapping
    public ResponseEntity<List<PeriodDTO>> findAll(){
        var periods = service.findAll();

        return ResponseEntity.ok().body(periods);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PeriodDTO> findById(@PathVariable Integer id) {
        var periods = service.findById(id);

        return ResponseEntity.ok().body(periods);
    }

    @PostMapping
    public ResponseEntity<PeriodDTO> insert(@RequestBody PeriodDTO dto){
        var period = service.insertPeriod(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(period.getPeriodId()).toUri();

        return ResponseEntity.created(uri).body(period);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PeriodDTO> update(@PathVariable Integer id, @RequestBody PeriodDTO dto){
        var period = service.updatePeriod(id, dto);

        return ResponseEntity.ok().body(period);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deletePeriod(id);

        return ResponseEntity.noContent().build();
    }
}
