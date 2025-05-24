package com.myrecipes.backend.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.UserDTO;
import com.myrecipes.backend.entity.User;
import com.myrecipes.backend.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserDTO login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        user.setCreatedAt(OffsetDateTime.now());

        return new UserDTO(userRepository.save(user));
    }

}
