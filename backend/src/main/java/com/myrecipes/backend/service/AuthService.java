package com.myrecipes.backend.service;

import org.springframework.stereotype.Service;

import com.myrecipes.backend.dto.UserDTO;
import com.myrecipes.backend.entity.User;
import com.myrecipes.backend.repository.UserRepository;

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

    public UserDTO register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }
        return new UserDTO(userRepository.save(user));
    }

}
