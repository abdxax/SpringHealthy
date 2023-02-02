package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "The name can not be null or empty")
    //@Column(columnDefinition = "not null")
    private Integer patientId;
    @NotNull(message = "The name can not be null or empty")
    //@Column(columnDefinition = "not null")
    private Integer patientDiseasesId;
    @NotNull(message = "The name can not be null or empty")
    //@Column(columnDefinition = "varchar(100) not null")
    private String result;

    //@Column(columnDefinition = "not null")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataTime;

    @PrePersist
    private void onCreate() {
        dataTime = new Date();
    }

}
