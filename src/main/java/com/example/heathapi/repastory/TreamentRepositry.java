package com.example.heathapi.repastory;

import com.example.heathapi.models.Treament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreamentRepositry extends JpaRepository<Treament,Integer> {
    Treament findByIdEquals(Integer id);
}
