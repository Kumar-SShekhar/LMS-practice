package com.shekhar.LmsPractice.repository;

import com.shekhar.LmsPractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByNameStartingWithIgnoreCase(char firstLetter);
}
