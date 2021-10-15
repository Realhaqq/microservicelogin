package com.haqq.microservice.repository;

import com.haqq.microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(String username);
}
