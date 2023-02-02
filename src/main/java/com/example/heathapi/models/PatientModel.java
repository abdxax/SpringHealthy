package com.example.heathapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class PatientModel {
    private Date start;
    private Date end;
}
