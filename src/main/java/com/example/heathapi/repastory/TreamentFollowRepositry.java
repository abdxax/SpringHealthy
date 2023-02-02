package com.example.heathapi.repastory;

import com.example.heathapi.models.TreamentFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TreamentFollowRepositry extends JpaRepository<TreamentFollow,Integer> {
    TreamentFollow findByIdEquals(Integer id);
    @Query("select u from TreamentFollow u where u.treamentTimeId =?1")
    public TreamentFollow TreamentTimeIde(Integer id);
}
