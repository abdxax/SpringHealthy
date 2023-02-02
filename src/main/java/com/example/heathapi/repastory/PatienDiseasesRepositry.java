package com.example.heathapi.repastory;

import com.example.heathapi.models.PatientDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatienDiseasesRepositry extends JpaRepository<PatientDiseases,Integer> {
    PatientDiseases findByIdEquals(Integer id);
    PatientDiseases findByPatientIdEquals(Integer id);
}
