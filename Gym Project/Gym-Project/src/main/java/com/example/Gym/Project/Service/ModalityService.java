package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.InstructorDTO;
import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.DTO.PeriodDTO;
import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Model.Period;
import com.example.Gym.Project.Repository.ModalityRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalityService {

    @Autowired
    private ModalityRepository modalityRepository;

    @Transactional
    public ModalityDTO findById(Integer id) {
        Modality modality = modalityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new ModalityDTO(modality);
    }

    @Transactional
    public List<ModalityDTO> findAll() {
        List<Modality> modalities = modalityRepository.findAll();
        return modalities.stream().map(x -> new ModalityDTO(x)).toList();
    }

    @Transactional
    public ModalityDTO insertModality(ModalityDTO dto) {
        Modality modality = new Modality();
        copyDtoToEntity(dto, modality);
        modalityRepository.save(modality);
        return new ModalityDTO(modality);
    }

    @Transactional
    public ModalityDTO updateModality(Integer id, ModalityDTO dto) {
        try{
            Modality modality = modalityRepository.getReferenceById(dto.getModalityId());
            copyDtoToEntity(dto, modality);
            modality = modalityRepository.save(modality);
            return new ModalityDTO(modality);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    @Transactional
    public void deleteModality(Integer id) {
        if(!modalityRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            modalityRepository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw new DataBaseException("Failed to delete resource");
        }
    }

    @Transactional
    public List<PeriodDTO> findPeriodByModality(Integer id) {
        List<Period> periods = modalityRepository.searchPeriodbyModality(id);

        return periods.stream().map(x -> new PeriodDTO(x)).toList();
    }

    public List<InstructorDTO> findInstructorByModality(Integer id) {
        List<Instructor> instructors = modalityRepository.searchInstructorbyModality(id);
        return instructors.stream().map(x -> new InstructorDTO(x)).toList();
    }

    public void copyDtoToEntity(ModalityDTO dto, Modality entity) {
        entity.setModalityId(dto.getModalityId());
        entity.setModalityName(dto.getModalityName());
        entity.setModalityDescription(dto.getModalityDescription());
        entity.setModalityDay(dto.getModalityDay());
    }

}