package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.TreamentTime;
import com.example.heathapi.repastory.TreamentTimeRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreamentTimeService {
    private final TreamentTimeRepositry treamentTimeRepositry;
    public List<TreamentTime> treamentTimes(){
        return treamentTimeRepositry.findAll();
    }
    public void addTreamentTime(TreamentTime treamentTime){
        treamentTimeRepositry.save(treamentTime);
    }

    public Boolean updateTreamentTime(Integer id,TreamentTime treamentTime){
        TreamentTime u=treamentTimeRepositry.findByIdEquals(id);

        if(u==null){
            return false;
        }
        treamentTime.setId(u.getId());
        treamentTimeRepositry.save(treamentTime);
        return true;
    }

    public Boolean deleteDTreamentTime(Integer id){
        TreamentTime u=treamentTimeRepositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        treamentTimeRepositry.delete(u);
        return true;
    }
}
