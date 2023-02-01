package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patientDiseases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "The name can not be null or empty")
    @Column(columnDefinition = "not null")
    private Integer patientId;
    @NotNull(message = "The name can not be null or empty")
    @Column(columnDefinition = "not null")
    private Integer diseasesId;

}
