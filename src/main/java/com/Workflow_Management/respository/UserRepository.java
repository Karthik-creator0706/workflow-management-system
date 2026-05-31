package com.Workflow_Management.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Workflow_Management.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}