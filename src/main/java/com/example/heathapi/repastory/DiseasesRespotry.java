package com.example.heathapi.repastory;

import com.example.heathapi.models.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseasesRespotry extends JpaRepository<Diseases,Integer> {
    Diseases findByIdEquals(Integer id);

}
