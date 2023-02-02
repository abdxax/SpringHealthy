package com.example.heathapi.controller;

import com.example.heathapi.models.Patient;
import com.example.heathapi.models.PatientDiseases;
import com.example.heathapi.services.PatientDiseasesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patienDiseases")
@RequiredArgsConstructor
public class PatienDiseasesController {
    private final PatientDiseasesService patientDiseasesService;
    @GetMapping("/allPatientDiseases")
    public List<PatientDiseases> getAll(){
        return patientDiseasesService.diseases();
    }
    @PostMapping("/addPatientDiseases")
    public ResponseEntity addPatient(@RequestBody @Valid PatientDiseases patientDiseases){
        patientDiseasesService.addDiseases(patientDiseases);
        return ResponseEntity.status(200).body("Add PatientDiseases done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePatientDiseases(@PathVariable Integer id,@RequestBody @Valid PatientDiseases patientDiseases){
        Boolean reslt=patientDiseasesService.updatePatientDiseases(id,patientDiseases);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatientDiseases(@PathVariable Integer id){
        Boolean reslt=patientDiseasesService.deletePatientDiseases(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}


