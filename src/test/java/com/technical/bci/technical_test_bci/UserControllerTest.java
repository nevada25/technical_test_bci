package com.technical.bci.technical_test_bci;

import com.technical.bci.technical_test_bci.clients.config.JwtUtil;
import com.technical.bci.technical_test_bci.controllers.UserController;
import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.Phone;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.services.UserService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUserSuccess()  {
        User mockUser = new User();
        mockUser.setId(Long.parseLong("1"));
        mockUser.setEmail("calderon200396@gmail.com");
        mockUser.setPassword("Kevin12");
        List<Phone> phones=new ArrayList<>();
        Phone mockPhone=new Phone();
        mockPhone.setId(Long.parseLong("1"));
        mockPhone.setNumber("935280674");
        mockPhone.setCitycode("Tarapoto");
        mockPhone.setCountrycode("San Martin");
        phones.add(mockPhone);
        mockUser.setPhones(phones);

        when(userService.registerUser(any())).thenReturn(mockUser);
        ResponseEntity<?> response = userController.registerUser(new User());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testRegisterUserEmailAlreadyExists() {
        when(userService.registerUser(any())).thenThrow(ConstraintViolationException.class);
        // Ejecuta la prueba
        ResponseEntity<?> response = userController.registerUser(new User());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }


}