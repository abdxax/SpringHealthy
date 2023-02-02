package com.example.heathapi.controller;

import com.example.heathapi.models.Result;
import com.example.heathapi.models.User;
import com.example.heathapi.services.ResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/result")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;
    @GetMapping("/allResults")
    public List<Result> getAll(){
        return resultService.results();
    }
    @PostMapping("/addResult")
    public ResponseEntity addResult(@RequestBody @Valid Result result){
        resultService.addResult(result);
        return ResponseEntity.status(200).body("Add Result done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateResult(@PathVariable Integer id,@RequestBody @Valid Result result){
        Boolean reslt=resultService.updateResult(id,result);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update Result done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResult(@PathVariable Integer id){
        Boolean reslt=resultService.deleteDiseases(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
