package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.PlanDTO;
import com.example.Gym.Project.Model.Plan;
import com.example.Gym.Project.Repository.PlanRespository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlanService {

    @Autowired
    private PlanRespository planRepository;


    public PlanDTO findById(Integer id){
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new PlanDTO(plan);
    }


    public List<PlanDTO> findAll(){
        var planos = planRepository.findAll();
        return planos.stream().map(PlanDTO::new).toList();
    }


    public PlanDTO insertPlan(PlanDTO dto) {

        Plan plan = new Plan();
        copyDtoToEntity(dto, plan);
        planRepository.save(plan);
        return new PlanDTO(plan);
    }


    public PlanDTO updatePlan(PlanDTO dto) {
        try{
            Plan plan = planRepository.getReferenceById(dto.getPlanId());
            copyDtoToEntity(dto, plan);
            plan = planRepository.save(plan);
            return new PlanDTO(plan);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }


    public void deletePlan(Integer id) {
        if(!planRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            planRepository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw new DataBaseException("Failed to delete resource");
        }
    }



    private void copyDtoToEntity(PlanDTO dto, Plan entity) {
        entity.setPlanName(dto.getPlanName());
        entity.setPlanDescription(dto.getPlanDescription());
        entity.setPlanPrice(dto.getPlanPrice());

    }




}