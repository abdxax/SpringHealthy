package com.example.heathapi.controller;

import com.example.heathapi.models.Treament;
import com.example.heathapi.models.User;
import com.example.heathapi.services.TreamentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/treament")
@RequiredArgsConstructor
public class TreamentController {
    private final TreamentService treamentService;
    @GetMapping("/allTreament")
    public List<Treament> getAll(){
        return treamentService.treaments();
    }
    @PostMapping("/addTreament")
    public ResponseEntity addTreament(@RequestBody @Valid Treament treament){
        treamentService.addTreament(treament);
        return ResponseEntity.status(200).body("Add User done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTreament(@PathVariable Integer id,@RequestBody @Valid Treament treament){
        Boolean reslt=treamentService.updateDiseases(id,treament);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTreament(@PathVariable Integer id){
        Boolean reslt=treamentService.deleteTreament(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
