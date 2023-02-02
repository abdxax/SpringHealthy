package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.Treament;
import com.example.heathapi.repastory.TreamentRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreamentService {
    private final TreamentRepositry treamentRepositry;
    public List<Treament> treaments(){
        return treamentRepositry.findAll();
    }
    public void addTreament(Treament treament){
        treamentRepositry.save(treament);
    }

    public Boolean updateDiseases(Integer id,Treament treament){
        Treament u=treamentRepositry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        treament.setId(u.getId());
        treamentRepositry.save(treament);
        return true;
    }

    public Boolean deleteTreament(Integer id){
        Treament u=treamentRepositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        treamentRepositry.delete(u);
        return true;
    }
}
