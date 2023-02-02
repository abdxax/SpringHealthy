package com.example.heathapi.controller;

import com.example.heathapi.models.TreamentTime;
import com.example.heathapi.models.User;
import com.example.heathapi.services.TreamentTimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/treamentTime")
@RequiredArgsConstructor
public class TreamentTimeController {
    private final TreamentTimeService treamentTimeService;
    @GetMapping("/allTreamentTime")
    public List<TreamentTime> getAll(){
        return treamentTimeService.treamentTimes();
    }
    @PostMapping("/addTreamentTime")
    public ResponseEntity addTreamentTime(@RequestBody @Valid TreamentTime treamentTime){
       treamentTimeService.addTreamentTime(treamentTime);
        return ResponseEntity.status(200).body("Add TreamentTime done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTreamentTime(@PathVariable Integer id,@RequestBody @Valid TreamentTime treamentTime){
        Boolean reslt=treamentTimeService.updateTreamentTime(id,treamentTime);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTreamentTime(@PathVariable Integer id){
        Boolean reslt=treamentTimeService.deleteDTreamentTime(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
