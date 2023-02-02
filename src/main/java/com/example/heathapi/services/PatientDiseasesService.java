package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.PatientDiseases;
import com.example.heathapi.repastory.PatienDiseasesRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientDiseasesService {
    private final PatienDiseasesRepositry patienDiseasesRepositry;

    public List<PatientDiseases> diseases(){
        return patienDiseasesRepositry.findAll();
    }
    public void addDiseases(PatientDiseases patientDiseases){
        patienDiseasesRepositry.save(patientDiseases);
    }

    public Boolean updatePatientDiseases(Integer id,PatientDiseases patientDiseases){
        PatientDiseases u=patienDiseasesRepositry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        patientDiseases.setId(u.getId());
        patienDiseasesRepositry.save(patientDiseases);
        return true;
    }

    public Boolean deletePatientDiseases(Integer id){
        PatientDiseases u=patienDiseasesRepositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        patienDiseasesRepositry.delete(u);
        return true;
    }


}
