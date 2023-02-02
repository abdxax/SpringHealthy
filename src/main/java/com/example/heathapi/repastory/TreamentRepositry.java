package com.example.heathapi.repastory;

import com.example.heathapi.models.Treament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreamentRepositry extends JpaRepository<Treament,Integer> {
    Treament findByIdEquals(Integer id);
    List<Treament> findByPatientIdEquals(Integer paid);

    @Query("select u from Treament u where u.patientId =?1")
    public Treament findByPatientId(Integer id);
}
