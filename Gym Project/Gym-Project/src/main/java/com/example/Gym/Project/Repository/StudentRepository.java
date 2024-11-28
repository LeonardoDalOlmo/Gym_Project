package com.example.Gym.Project.Repository;

import com.example.Gym.Project.Model.Modality;
import com.example.Gym.Project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT " +
            " DISTINCT TB_SUBSCRIPTION.MODALITYID " +
            " FROM TB_SUBSCRIPTION " +
            " INNER JOIN TB_MODALITY ON (TB_SUBSCRIPTION.MODALITYID = TB_MODALITY.MODALITYID) " +
            " INNER JOIN TB_STUDENT ON (TB_SUBSCRIPTION.STUDENTID = TB_STUDENT.STUDENTID) " +
            " WHERE TB_STUDENT.STUDENTID = 1 --INSERIR CÓDIGO DO ESTUDANTE", nativeQuery = true)
    List<Integer> searchModalitybyStudent(Integer id);

}
