package com.example.heathapi.controller;

import com.example.heathapi.models.TreamentFollow;
import com.example.heathapi.models.User;
import com.example.heathapi.services.TreamentFollowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/treamentFollow")
@RequiredArgsConstructor
public class TreamentFollowController {
    private final TreamentFollowService treamentFollowService;
    @GetMapping("/allTreamentFollow")
    public List<TreamentFollow> getAll(){
        return treamentFollowService.treamentFollows();
    }
    @PostMapping("/addTreamentFollow")
    public ResponseEntity addTreamentFollow(@RequestBody @Valid TreamentFollow treamentFollow){
        treamentFollowService.addTreamentFollow(treamentFollow);
        return ResponseEntity.status(200).body("Add TreamentFollow done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTreamentFollow(@PathVariable Integer id,@RequestBody @Valid TreamentFollow treamentFollow){
        Boolean reslt=treamentFollowService.updateTreamentFollow(id,treamentFollow);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update TreamentFollow done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTreamentFollow(@PathVariable Integer id){
        Boolean reslt=treamentFollowService.deleteTreamentFollow(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete TreamentFollow done!");
    }

}
