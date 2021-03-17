package com.example.springejercicio4.repository;

import com.example.springejercicio4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
