package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treamentTime")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreamentTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@NotNull(message = "Cant be null")
@Column(columnDefinition = " not null")
    private Integer treamsId;
    @NotNull(message = "Cant be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String time;
}
