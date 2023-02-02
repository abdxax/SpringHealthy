package com.example.heathapi.controller;

import com.example.heathapi.models.Patient;
import com.example.heathapi.models.User;
import com.example.heathapi.repastory.PatientRepositrt;
import com.example.heathapi.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @GetMapping("/allPatient")
    public List<Patient> getAll(){
        return patientService.patients();
    }
    @PostMapping("/addPatient")
    public ResponseEntity addPatient(@RequestBody @Valid Patient Patient){
        patientService.addpPatient(Patient);
        return ResponseEntity.status(200).body("Add User done!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePatient(@PathVariable Integer id,@RequestBody @Valid Patient patient){
        Boolean reslt=patientService.updatePatient(id,patient);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Update user done!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id){
        Boolean reslt=patientService.deletePatient(id);
        if(!reslt){
            return  ResponseEntity.status(400).body("The id is not correct");
        }
        return ResponseEntity.status(200).body("Delete user done!");
    }
}
