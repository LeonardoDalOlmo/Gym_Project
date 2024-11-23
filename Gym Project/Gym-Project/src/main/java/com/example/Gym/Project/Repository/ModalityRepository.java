package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Integer> {
    @Query(value = "SELECT" +
            "    MP.PERIODID," +
            "TB_PERIOD.PERIODNAME" +
            "FROM MODALITY_PERIOD MP" +
            "    INNER JOIN TB_PERIOD ON (MP.PERIODID = TB_PERIOD.PERIODID)" +
            "INNER JOIN TB_MODALITY ON (MP.MODALITYID = TB_MODALITY.MODALITYID)" +
            "WHERE TB_MODALITY.MODALITYID = 1 --INSERIR CÓDIGO DA MODALIDADE", nativeQuery = true)
    List<Period> searchPeriodbyModality(Integer id);

    @Query(value = "SELECT " +
            "    MI.INSTRUCTORID," +
            "TB_INSTRUCTOR.INSTRUCTORNAME" +
            "FROM MODALITY_INSTRUCTOR MI" +
            "    INNER JOIN TB_MODALITY  ON (MI.MODALITYID = TB_MODALITY.MODALITYID)" +
            "    INNER JOIN TB_INSTRUCTOR ON (MI.INSTRUCTORID = TB_INSTRUCTOR.INSTRUCTORID)" +
            "WHERE TB_MODALITY.MODALITYID = 1 --INSERIR CÓDIGO DA MODALIDADE", nativeQuery = true)
    List<Instructor> searchInstructorbyModality(Integer id);
}
