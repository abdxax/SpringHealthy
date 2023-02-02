package com.example.heathapi.repastory;

import com.example.heathapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepstory extends JpaRepository<User,Integer> {
    User findByIdEquals(Integer id);
}
