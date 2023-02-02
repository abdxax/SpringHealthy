package com.example.heathapi.controller;

import com.example.heathapi.models.Diseases;
import com.example.heathapi.models.User;
import com.example.heathapi.services.DiseasesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/diseases")
public class DiseasesController {
    private final DiseasesService diseasesService;

    @GetMapping("/allDiseases")
    public List<Diseases> getAll(){
        return diseasesService.diseases();
    }
    @PostMapping("/addDiseases")
    public ResponseEntity addDiseases(@RequestBody @Valid Diseases diseases){
        diseasesService.addDiseases(diseases);
        return ResponseEntity.status(200).body("Add User done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDiseases(@PathVariable Integer id,@RequestBody @Valid Diseases diseases){
        Boolean reslt=diseasesService.updateDiseases(id,diseases);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update Diseases done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDiseases(@PathVariable Integer id){
        Boolean reslt=diseasesService.deleteDiseases(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
