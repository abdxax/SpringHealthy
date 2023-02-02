package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.TreamentFollow;
import com.example.heathapi.repastory.TreamentFollowRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreamentFollowService {
    private TreamentFollowRepositry treamentFollowRepositry;
    public List<TreamentFollow> treamentFollows(){
        return treamentFollowRepositry.findAll();
    }
    public void addTreamentFollow(TreamentFollow treamentFollow){
        treamentFollowRepositry.save(treamentFollow);
    }

    public Boolean updateTreamentFollow(Integer id,TreamentFollow treamentFollow){
        TreamentFollow u=treamentFollowRepositry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        treamentFollow.setId(u.getId());
        treamentFollowRepositry.save(treamentFollow);
        return true;
    }

    public Boolean deleteTreamentFollow(Integer id){
        TreamentFollow u=treamentFollowRepositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        treamentFollowRepositry.delete(u);
        return true;
    }
}
