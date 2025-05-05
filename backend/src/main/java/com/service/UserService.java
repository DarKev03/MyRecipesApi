package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
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
