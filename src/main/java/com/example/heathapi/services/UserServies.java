package com.example.heathapi.services;

import com.example.heathapi.handlingErrors.ApiException;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.UserRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServies {
    private final UserRepstory userRepstory;

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



}
