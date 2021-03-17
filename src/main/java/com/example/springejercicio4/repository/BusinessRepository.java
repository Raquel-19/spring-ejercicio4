package com.example.springejercicio4.repository;

import com.example.springejercicio4.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository <Business, Long> {
}
