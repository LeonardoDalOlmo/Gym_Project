package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.PeriodDTO;
import com.example.Gym.Project.Model.Period;
import com.example.Gym.Project.Repository.PeriodRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    public PeriodDTO findById(Integer id) {
        Period period = periodRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new PeriodDTO(period);
    }

    public PeriodDTO findAll(PeriodDTO periodDTO) {
        return (PeriodDTO) periodRepository.findAll();
    }

    public PeriodDTO insertPeriod(PeriodDTO dto) {
        Period period = new Period();
        copyDtoToEntity(dto, period);
        periodRepository.save(period);
        return new PeriodDTO(period);
    }

    public PeriodDTO updatePeriod(PeriodDTO dto) {
        try{
            Period period = periodRepository.getReferenceById(dto.getPeriodId());
            copyDtoToEntity(dto, period);
            period = periodRepository.save(period);
            return new PeriodDTO(period);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public void deletePeriod(Integer id) {
        if(!periodRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            periodRepository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw new DataBaseException("Failed to delete resource");
        }
    }

    public void copyDtoToEntity(PeriodDTO dto, Period entity) {
        entity.setPeriodName(dto.getPeriodName());
        entity.setPeriodStartHour(dto.getPeriodStartHour());
        entity.setPeriodEndHour(dto.getPeriodEndHour());
    }
}
