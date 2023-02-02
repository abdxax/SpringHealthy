package com.example.heathapi.repastory;

import com.example.heathapi.models.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepositry extends JpaRepository<Following,Integer> {
    Following findByIdEquals(Integer id);
    List<Following> findByUserIdEquals(Integer userId);
}
