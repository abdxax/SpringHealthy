package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The name can not be null or empty")
    @Column(columnDefinition = "varchar(50) not null ")
    private String name;
    @NotEmpty(message = "The email can not be null or empty")
    @Column(columnDefinition = "varchar(100) not null unique")
    @Email
    private String email;
    @NotEmpty(message = "The email can not be null or empty")
    @Column(columnDefinition = "varchar(100) not null")
    @Size(min = 6)
    private String password;
    @NotEmpty(message = "The email can not be null or empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;
}
