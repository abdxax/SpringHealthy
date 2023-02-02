package com.example.heathapi.services;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.Following;
import com.example.heathapi.repastory.FollowingRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowingSerive {
    private final FollowingRepositry followingRepositry;
    public List<Following> followings(){
        return followingRepositry.findAll();
    }
    public void addFollowing(Following following){
        followingRepositry.save(following);
    }

    public Boolean updateFollowing(Integer id,Following following){
        Following u=followingRepositry.findByIdEquals(id);
        if(u==null){
            return false;
        }
        following.setId(u.getId());
        followingRepositry.save(following);
        return true;
    }

    public Boolean deleteFollowing(Integer id){
        Following u=followingRepositry.findByIdEquals(id);
        if(u==null){
            return false;

        }

        followingRepositry.delete(u);
        return true;
    }
}
