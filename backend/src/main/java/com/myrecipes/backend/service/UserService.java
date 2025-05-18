package com.myrecipes.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.UserDTO;
import com.myrecipes.backend.entity.User;
import com.myrecipes.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(UserDTO::new);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO saveUser(User user) {
        return new UserDTO(userRepository.save(user));
    }

    public Optional<UserDTO> updateUser(Long id, User user) {
        return userRepository.findById(id).map(existing -> {
            user.setId(id);
            return new UserDTO(userRepository.save(user));
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
