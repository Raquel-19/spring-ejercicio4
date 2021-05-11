package com.example.springejercicio4.repository;

import com.example.springejercicio4.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository <Business, Long> {

    List<Business> findByContact (String contact);
}
