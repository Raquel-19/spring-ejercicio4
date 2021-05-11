package com.example.springejercicio4.service;

import com.example.springejercicio4.model.Business;
import com.example.springejercicio4.model.User;

import java.util.List;
import java.util.Optional;

public interface BusinessService {

    List<Business> findAllBusiness ();
    Optional<Business> findById (Long id);
    List <Business> filterByContact (String contact);

    Business createBusiness (Business business);

    Business updateBusiness (Business business);

    void deleteAll ();

    Optional<Business> calculateBilling (Long numberBusiness);
}
