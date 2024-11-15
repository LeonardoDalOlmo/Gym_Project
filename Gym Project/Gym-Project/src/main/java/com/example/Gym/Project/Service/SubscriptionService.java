package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.SubscriptionDTO;
import com.example.Gym.Project.Model.Subscription;
import com.example.Gym.Project.Repository.SubscriptionRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionDTO findById(Integer id) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new SubscriptionDTO(subscription);
    }

    public List<SubscriptionDTO> findAll(SubscriptionDTO subscriptionDTO) {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptions.stream().map(x -> new SubscriptionDTO(x)).toList();
    }

    public SubscriptionDTO insertSubscription(SubscriptionDTO dto) {
        Subscription subscription = new Subscription();
        copyDtoToEntity(dto, subscription);
        subscriptionRepository.save(subscription);
        return new SubscriptionDTO(subscription);
    }

    public SubscriptionDTO updateSubscription(Integer id, SubscriptionDTO dto) {
        try{
            Subscription subscription = subscriptionRepository.getReferenceById(dto.getSubscriptionId());
            copyDtoToEntity(dto, subscription);
            subscription = subscriptionRepository.save(subscription);
            return new SubscriptionDTO(subscription);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public void deleteSubscription(Integer id) {
        if(!subscriptionRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            subscriptionRepository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw new DataBaseException("Failed to delete resource");
        }
    }

    public void copyDtoToEntity(SubscriptionDTO dto, Subscription entity) {
        entity.setSubscriptionId(dto.getSubscriptionId());
        entity.setStudentId(dto.getStudentId());
        entity.setPlanId(dto.getPlanId());
        entity.setPreiodId(dto.getPeriodId());
        entity.setModalityId(dto.getModalityId());
        entity.setSubscriptionStartDate(dto.getSubscriptionStartDate());
        entity.setSubscriptionEndDate(dto.getSubscriptionEndDate());
    }

}