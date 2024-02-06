package com.technical.bci.technical_test_bci;

import com.technical.bci.technical_test_bci.clients.config.JwtUtil;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.repositories.UserRepository;
import com.technical.bci.technical_test_bci.services.impl.UserServiceImpl;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserServiceImpl userService;

    public UserServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUserSuccess(){
        when(userRepository.findByEmail(any())).thenReturn(null);
        when(userRepository.save(any())).thenReturn(new User());
        User user = new User();
        userService.registerUser(user);
    }



}