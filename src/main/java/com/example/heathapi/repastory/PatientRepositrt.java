package com.example.heathapi.repastory;

import com.example.heathapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositrt extends JpaRepository<Patient,Integer> {
    Patient findByIdEquals(Integer id);
    Patient findByUserIdEquals(Integer userId);
}
