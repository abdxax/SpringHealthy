package com.example.heathapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treament")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer patientId;
    private Integer freq;
    private Integer times;

}
