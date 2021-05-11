package com.example.springejercicio4.service.impl;

import com.example.springejercicio4.model.User;
import com.example.springejercicio4.repository.UserRepository;
import com.example.springejercicio4.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repositoryUser;

    public UserServiceImpl(UserRepository repository) {
        this.repositoryUser = repository;
    }

    @Override
    public List<User> findAllUsers() {
        log.info("findAllUsers");
        return repositoryUser.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        log.info("findOneUser");
        if (id == null)
            return Optional.empty();

        return repositoryUser.findById(id);
    }

    @Override
    public List<User> filterByCountry (String country) {
       log.info("filterByCountry");
       return repositoryUser.findByCountry(country);
    }

    @Override
    public User createUser(User user) {
        log.info("createUser");
        if (ObjectUtils.isEmpty(user))
            return null;
        return repositoryUser.save(user);
    }

    @Override
    public User updateUser(User user) {
        log.info("updateUser");
        if (ObjectUtils.isEmpty(user))
            return null;
        return repositoryUser.save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.info("deleteUserById");
        if(id != null && repositoryUser.existsById(id))
            repositoryUser.deleteById(id);
    }
}
