package com.example.heathapi.services;

import com.example.heathapi.handlingErrors.ApiException;
import com.example.heathapi.models.*;
import com.example.heathapi.repastory.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepositrt patientRepositrt;
    private final PatienDiseasesRepositry patienDiseasesRepositry;
    private final ResultRpositry resultRpositry;
    private final UserRepstory userRepstory;
    private final DiseasesRespotry diseasesRespotry;
    private final TreamentRepositry treamentRepositry;
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

    public Double hba1c(Integer patienId,Integer diss, Date start, Date end){
        PatientDiseases patientDiseases=patienDiseasesRepositry.findByPatientIdEqualsAndDiseasesIdEquals(patienId,diss);
        if(patientDiseases==null){
            return 0.0;
        }
        List<Result> results=resultRpositry.findByDate(patientDiseases.getId(),start,end);
        if(results.size()<=0){
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

    public List<Result> AllResltDes(Integer idPat,Integer des){
        PatientDiseases diseases=patienDiseasesRepositry.findByPatientIdEqualsAndDiseasesIdEquals(idPat,des);
        if(diseases==null){
            throw new ApiException("The data not fount ");
        }
        List<Result> results=resultRpositry.findByPatientDiseasesIdEquals(diseases.getId());
          return  results;
    }

    public ReportPatient report(Integer patId){
        Patient p=patientRepositrt.findByIdEquals(patId);
        if(p==null){
            throw new ApiException("The id is not correct ");
        }
        User user=userRepstory.findByIdEquals(p.getUserId());
        if(user==null){
            throw new ApiException("data not fount ");
        }
        List<PatientDiseases> patientDiseases=patienDiseasesRepositry.findByPatientIdEquals(p.getId());
        if(patientDiseases.size()<0){
            throw new ApiException("This patient doesn't have any diseases ");
        }
        List<Diseases> diseases=new ArrayList<>();
        for(PatientDiseases d:patientDiseases){
            diseases.add(diseasesRespotry.findByIdEquals(d.getDiseasesId()));
        }

        List<Treament> treamentList=treamentRepositry.findByPatientIdEquals(p.getId());

        return new ReportPatient(user,diseases,treamentList);


    }


}

