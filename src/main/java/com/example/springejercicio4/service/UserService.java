package com.example.springejercicio4.service;

import com.example.springejercicio4.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers ();
    Optional<User> findById (Long id);
    List <User> filterByCountry (String country);

    User createUser (User user);

    User updateUser (User user);

    void deleteById (Long id);
}
