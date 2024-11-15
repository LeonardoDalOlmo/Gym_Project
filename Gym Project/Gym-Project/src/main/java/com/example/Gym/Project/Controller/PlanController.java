package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.PlanDTO;
import com.example.Gym.Project.Service.PlanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/plans")
public class PlanController {

    @Autowired
    private PlanService service;

    @GetMapping
    public ResponseEntity<List<PlanDTO>> findAll(){
        var plans = service.findAll();

        return ResponseEntity.ok().body(plans);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PlanDTO> findById(@PathVariable Integer id) {
        var plans = service.findById(id);

        return ResponseEntity.ok().body(plans);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PlanDTO> insert(@RequestBody PlanDTO dto){
        var plan = service.insertPlan(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(plan.getPlanId()).toUri();

        return ResponseEntity.created(uri).body(plan);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<PlanDTO> update(@PathVariable Integer id, @RequestBody PlanDTO dto){
        var plan = service.updatePlan(id, dto);

        return ResponseEntity.ok().body(plan);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deletePlan(id);

        return ResponseEntity.noContent().build();
    }

}
