package com.example.heathapi.repastory;

import com.example.heathapi.models.PatientDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatienDiseasesRepositry extends JpaRepository<PatientDiseases,Integer> {
    PatientDiseases findByIdEquals(Integer id);
    PatientDiseases findByPatientIdEqualsAndDiseasesIdEquals(Integer PATIENTID,Integer disId);
    List<PatientDiseases> findByPatientIdEquals(Integer pid);
}
