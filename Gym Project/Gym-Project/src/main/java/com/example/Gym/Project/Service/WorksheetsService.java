package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.WorksheetsDTO;
import com.example.Gym.Project.Model.Student;
import com.example.Gym.Project.Model.Worksheets;
import com.example.Gym.Project.Repository.WorksheetsRepository;
import com.example.Gym.Project.Service.Exceptions.DataBaseException;
import com.example.Gym.Project.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WorksheetsService {

    @Autowired
    private WorksheetsRepository worksheetsRepository;


    public WorksheetsDTO findById(Integer id) {
        Worksheets worksheets = worksheetsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new WorksheetsDTO(worksheets);
    }

    public WorksheetsDTO findAll(WorksheetsDTO worksheetsDTO) {
        return (WorksheetsDTO) worksheetsRepository.findAll();
    }

    public WorksheetsDTO insertWorksheet(WorksheetsDTO dto) {
        Worksheets worksheets = new Worksheets();
        copyDtoToEntity(dto, worksheets);
        worksheetsRepository.save(worksheets);
        return new WorksheetsDTO(worksheets);
    }

    public WorksheetsDTO updateWorksheet(WorksheetsDTO dto) {
        try{
            Worksheets worksheets = new Worksheets();
            copyDtoToEntity(dto, worksheets);
            worksheets = worksheetsRepository.save(worksheets);
            return new WorksheetsDTO(worksheets);
        }
        catch(ResourceNotFoundException e){
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public void deleteWorksheet(Integer id) {
        if(!worksheetsRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            worksheetsRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new DataBaseException("Failed to delete resource");
        }
    }

    public void copyDtoToEntity(WorksheetsDTO dto, Worksheets entity) {
        entity.setStudentId(dto.getStudentId());
        entity.setWorksheetDay(dto.getWorksheetDay());
        entity.setMachineDescription(dto.getMachineDescription());
        entity.setSetNumber(dto.getSetNumber());
        entity.setRepetitionNumber(dto.getRepetitionNumber());
    }

}