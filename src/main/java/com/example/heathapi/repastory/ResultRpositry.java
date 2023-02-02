package com.example.heathapi.repastory;

import com.example.heathapi.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRpositry extends JpaRepository<Result,Integer> {
    Result findByIdEquals(Integer id);
}
