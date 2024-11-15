package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.ModalityDTO;
import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Repository.ModalityRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalityService {

    @Autowired
    private ModalityRepository modalityRepository;

    public ModalityDTO findById(Integer id) {
        Modality modality = modalityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found "));
        return new ModalityDTO(modality);
    }

    public List<ModalityDTO> findAll() {
        List<Modality> modalities = modalityRepository.findAll();
        return modalities.stream().map(x -> new ModalityDTO(x)).toList();
    }

    public ModalityDTO insertModality(ModalityDTO dto) {
        Modality modality = new Modality();
        copyDtoToEntity(dto, modality);
        modalityRepository.save(modality);
        return new ModalityDTO(modality);
    }

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

    public void copyDtoToEntity(ModalityDTO dto, Modality entity) {
        entity.setModalityId(dto.getModalityId());
        entity.setModalityName(dto.getModalityName());
        entity.setModalityDescription(dto.getModalityDescription());
        entity.setModalityDay(dto.getModalityDay());
    }

}