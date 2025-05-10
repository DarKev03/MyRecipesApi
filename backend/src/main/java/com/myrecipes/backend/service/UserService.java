package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myrecipes.backend.entity.User;
import com.myrecipes.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional <User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setAdmin(user.isAdmin());
            user.setName(user.getName());            
            userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
