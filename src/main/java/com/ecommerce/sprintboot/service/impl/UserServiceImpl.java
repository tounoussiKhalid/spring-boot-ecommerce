package com.ecommerce.sprintboot.service.impl;

import com.ecommerce.sprintboot.entity.User;
import com.ecommerce.sprintboot.repository.UserRepository;
import com.ecommerce.sprintboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IService<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User employee) {
        return userRepository.save(employee);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
