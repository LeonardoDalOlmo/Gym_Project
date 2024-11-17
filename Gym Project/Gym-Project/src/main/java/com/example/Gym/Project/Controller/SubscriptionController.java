package com.example.Gym.Project.Controller;

import com.example.Gym.Project.DTO.SubscriptionDTO;
import com.example.Gym.Project.Service.SubscriptionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<SubscriptionDTO>> findAll(){
        var subscriptions = service.findAll();

        return ResponseEntity.ok().body(subscriptions);
    }

    @GetMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<SubscriptionDTO> findById(@PathVariable Integer id) {
        var subscription = service.findById(id);

        return ResponseEntity.ok().body(subscription);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<SubscriptionDTO> insert(@RequestBody SubscriptionDTO dto){
        var subscription = service.insertSubscription(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(subscription.getSubscriptionId()).toUri();

        return ResponseEntity.created(uri).body(subscription);
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<SubscriptionDTO> update(@PathVariable Integer id, @RequestBody SubscriptionDTO dto){
        var subscription = service.updateSubscription(id, dto);

        return ResponseEntity.ok().body(subscription);
    }

    @DeleteMapping(value = "/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteSubscription(id);

        return ResponseEntity.noContent().build();
    }
}