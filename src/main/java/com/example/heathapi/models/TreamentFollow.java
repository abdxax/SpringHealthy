package com.example.heathapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "treamentFollow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreamentFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Cant be null")
    //@Column(columnDefinition = " not null",name = "treamentTimeIds")
    private Integer treamentTimeId;

    private Boolean IsTake;
}
