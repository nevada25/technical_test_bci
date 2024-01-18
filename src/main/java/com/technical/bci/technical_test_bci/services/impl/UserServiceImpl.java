package com.technical.bci.technical_test_bci.services.impl;

import com.technical.bci.technical_test_bci.clients.config.JwtUtil;
import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.repositories.UserRepository;
import com.technical.bci.technical_test_bci.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User registerUser(User user) throws EmailAlreadyExistsException {
        // Verificar si el correo ya está registrado
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailAlreadyExistsException();
        }

        // Puedes agregar lógica adicional de validación antes de guardar el usuario en la base de datos

        // Guardar el usuario
        String token = jwtUtil.create(user.getEmail());
        user.setToken(token);
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}