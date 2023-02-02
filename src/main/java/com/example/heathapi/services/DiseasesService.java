package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.DiseasesRespotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseasesService {
    private final DiseasesRespotry diseasesRespotry;
    public List<Diseases> diseases(){
        return diseasesRespotry.findAll();
    }
    public void addDiseases(Diseases diseases){
        diseasesRespotry.save(diseases);
    }

    public Boolean updateDiseases(Integer id,Diseases diseases){
        Diseases u=diseasesRespotry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        diseases.setId(u.getId());
        diseasesRespotry.save(diseases);
        return true;
    }

    public Boolean deleteDiseases(Integer id){
        Diseases u=diseasesRespotry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        diseasesRespotry.delete(u);
        return true;
    }


}
