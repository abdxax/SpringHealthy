package com.example.heathapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportPatient {
    private User user;
    private List<Diseases> diseases;
    private List<Treament> treaments;
}
