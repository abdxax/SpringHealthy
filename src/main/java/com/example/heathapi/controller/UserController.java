package com.example.heathapi.controller;

import com.example.heathapi.models.User;
import com.example.heathapi.services.UserServies;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    public final UserServies userServies;
    @GetMapping("/allUser")
    public List<User> getAll(){
        return userServies.users();
    }
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        userServies.addUser(user);
        return ResponseEntity.status(200).body("Add User done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user){
        Boolean reslt=userServies.updateUser(id,user);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean reslt=userServies.deleteUser(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }

    @GetMapping("/getAllFollowing/{id}")
    public ResponseEntity getAllFollow(@PathVariable Integer id){
        List<User> users=userServies.getFollowing(id);
        return ResponseEntity.status(200).body(users);
    }

}
