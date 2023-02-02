package com.example.heathapi.services;

import com.example.heathapi.handlingErrors.ApiException;
import com.example.heathapi.models.Following;
import com.example.heathapi.models.Patient;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.FollowingRepositry;
import com.example.heathapi.repastory.PatientRepositrt;
import com.example.heathapi.repastory.UserRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServies {
    private final UserRepstory userRepstory;
    private final FollowingRepositry followingRepositry;
    private final PatientRepositrt patientRepositrt;

    public List<User> users(){
        return userRepstory.findAll();
    }
    public void addUser(User user){
        userRepstory.save(user);
    }

    public Boolean updateUser(Integer id,User user){
        User u=userRepstory.findByIdEquals(id);
        if(u==null){
           return false;
        }
        user.setId(u.getId());
        userRepstory.save(user);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User u=userRepstory.findByIdEquals(id);
        if(u==null){
           return false;

        }

        userRepstory.delete(u);
        return true;
    }

    public List<User> getFollowing(Integer userId){
        List<Following> followings=followingRepositry.findByUserIdEquals(userId);
        List<User> users=new ArrayList<>();
        for(Following f:followings){
            Patient p=patientRepositrt.findByIdEquals(f.getPatientId());
            if(p==null){
                continue;
            }
            users.add(userRepstory.findByIdEquals(p.getUserId()));
        }

        return users;
    }




}
