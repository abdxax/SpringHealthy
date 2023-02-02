package com.example.heathapi.services;

import com.example.heathapi.models.Patient;
import com.example.heathapi.models.PatientDiseases;
import com.example.heathapi.models.Result;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.PatienDiseasesRepositry;
import com.example.heathapi.repastory.PatientRepositrt;
import com.example.heathapi.repastory.ResultRpositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepositrt patientRepositrt;
    private final PatienDiseasesRepositry patienDiseasesRepositry;
    private final ResultRpositry resultRpositry;
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

    public Double hba1c(Integer patienId, Date start, Date end){
        PatientDiseases patientDiseases=patienDiseasesRepositry.findByPatientIdEquals(patienId);
        if(patientDiseases==null){
            return 0.0;
        }
        List<Result> results=resultRpositry.findByDate(patientDiseases.getId(),start,end);
        if(results.size()<0){
            return 0.0;
        }
        double result=0;
        for(Result r : results){
            result+=Integer.parseInt(r.getResult());
        }

        double finalResult=result/results.size();
        double hab=2.6+(0.03*finalResult);
        return hab;
    }


}

