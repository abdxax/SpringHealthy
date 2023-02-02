package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "following")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "The userId can not be null or empty")
   // @Column(columnDefinition = "not null")
    private Integer userId;
    @NotNull(message = "The patient Id can not be null or empty")
   // @Column(columnDefinition = " not null")
    private Integer patientId;

}
