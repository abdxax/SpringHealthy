package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.Result;
import com.example.heathapi.repastory.ResultRpositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRpositry resultRpositry;
    public List<Result> results(){
        return resultRpositry.findAll();
    }
    public void addResult(Result result){
        resultRpositry.save(result);
    }

    public Boolean updateResult(Integer id,Result result){
        Result u=resultRpositry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        result.setId(u.getId());
        resultRpositry.save(result);
        return true;
    }

    public Boolean deleteDiseases(Integer id){
        Result u=resultRpositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        resultRpositry.delete(u);
        return true;
    }
}
