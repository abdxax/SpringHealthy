package com.example.heathapi.services;

import com.example.heathapi.models.Patient;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.PatientRepositrt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepositrt patientRepositrt;
    public List<Patient> patients(){
        return patientRepositrt.findAll();
    }
    public void addpPatient(Patient patient){
        patientRepositrt.save(patient);
    }

    public Boolean updatePatient(Integer id,Patient patient){
        Patient u=patientRepositrt.findByIdEquals(id);
        if(u==null){
            return false;
        }
        patient.setId(u.getId());
        patientRepositrt.save(patient);
        return true;
    }

    public Boolean deletePatient(Integer id){
        Patient u=patientRepositrt.findByIdEquals(id);
        if(u==null){
            return false;

        }

        patientRepositrt.delete(u);
        return true;
    }
}

