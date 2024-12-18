package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Instructor;
import com.example.Gym.Project.Model.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query(value =
            "SELECT " +
                    " MI.MODALITYID " +
                    " FROM MODALITY_INSTRUCTOR MI " +
                    " INNER JOIN TB_MODALITY  ON (MI.MODALITYID = TB_MODALITY.MODALITYID) " +
                    " INNER JOIN TB_INSTRUCTOR ON (MI.INSTRUCTORID = TB_INSTRUCTOR.INSTRUCTORID) " +
                    " WHERE TB_INSTRUCTOR.INSTRUCTORID = ?1 ", nativeQuery = true)
    List<Integer> searchModalitybyInstructor(Integer id);




}
