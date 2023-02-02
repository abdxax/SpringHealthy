package com.example.heathapi.repastory;

import com.example.heathapi.models.TreamentFollow;
import com.example.heathapi.models.TreamentTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreamentTimeRepositry extends JpaRepository<TreamentTime,Integer> {
    TreamentTime findByIdEquals(Integer id);
}
