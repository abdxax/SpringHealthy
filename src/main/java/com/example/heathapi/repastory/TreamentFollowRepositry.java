package com.example.heathapi.repastory;

import com.example.heathapi.models.TreamentFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreamentFollowRepositry extends JpaRepository<TreamentFollow,Integer> {
    TreamentFollow findByIdEquals(Integer id);
}
