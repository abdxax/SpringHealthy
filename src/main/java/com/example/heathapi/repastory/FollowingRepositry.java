package com.example.heathapi.repastory;

import com.example.heathapi.models.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepositry extends JpaRepository<Following,Integer> {
    Following findByIdEquals(Integer id);
}
