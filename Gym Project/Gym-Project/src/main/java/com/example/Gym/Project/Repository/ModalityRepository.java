package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Integer> {

    @Query(value = "SELECT" +
            "        MI.MODALITYID," +
            "        TB_MODALITY.MODALITYNAME FROM MODALITY_INSTRUCTOR MI    " +
            "    INNER JOIN" +
            "        TB_MODALITY  " +
            "            ON (MI.MODALITYID = TB_MODALITY.MODALITYID)    " +
            "    INNER JOIN" +
            "        TB_INSTRUCTOR " +
            "            ON (MI.INSTRUCTORID = TB_INSTRUCTOR.INSTRUCTORID)" +
            "    WHERE" +
            "        TB_INSTRUCTOR.INSTRUCTORID = 1 --INSERIR CÓDIGO DO INSTRUTOR", nativeQuery = true)
    List<Instructor> searchInstructorbyModality(Integer id);
}
