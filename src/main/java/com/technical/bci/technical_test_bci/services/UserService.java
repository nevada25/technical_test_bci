package com.technical.bci.technical_test_bci.services;

import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user) ;
    Optional<User> getUserById(Long userId);
}
