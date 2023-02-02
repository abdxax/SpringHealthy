package com.example.heathapi.controller;

import com.example.heathapi.models.Following;
import com.example.heathapi.models.User;
import com.example.heathapi.services.FollowingSerive;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/following")
@RequiredArgsConstructor
public class FollowingController {
    private final FollowingSerive followingSerive;
    @GetMapping("/allFollowing")
    public List<Following> getAll(){
        return followingSerive.followings();
    }
    @PostMapping("/addFollowing")
    public ResponseEntity addFollowing(@RequestBody @Valid Following following){
        followingSerive.addFollowing(following);
        return ResponseEntity.status(200).body("Add User done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateFollowing(@PathVariable Integer id,@RequestBody @Valid Following following){
        Boolean reslt=followingSerive.updateFollowing(id,following);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFollowing(@PathVariable Integer id){
        Boolean reslt=followingSerive.deleteFollowing(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
