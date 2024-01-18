package com.technical.bci.technical_test_bci;

import com.technical.bci.technical_test_bci.clients.config.JwtUtil;
import com.technical.bci.technical_test_bci.controllers.UserController;
import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    void testRegisterUserSuccess() throws EmailAlreadyExistsException {
        // Simula un usuario registrado exitosamente
        User mockUser = new User();
        when(userService.registerUser(any())).thenReturn(mockUser);

        // Ejecuta la prueba
        ResponseEntity<?> response = userController.registerUser(new User());

        // Verifica que la respuesta tenga el código 201 (Created)
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Verifica que el token y otros campos se hayan agregado correctamente al usuario
        // Puedes agregar más verificaciones según tus necesidades específicas
    }

    @Test
    void testRegisterUserEmailAlreadyExists() throws EmailAlreadyExistsException {
        // Simula el caso en que el correo ya existe
        when(userService.registerUser(any())).thenThrow(new EmailAlreadyExistsException());

        // Ejecuta la prueba
        ResponseEntity<?> response = userController.registerUser(new User());

        // Verifica que la respuesta tenga el código 400 (Bad Request)
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        // Verifica que el mensaje de error sea el esperado
        // Puedes agregar más verificaciones según tus necesidades específicas
    }

    // Agrega más pruebas según sea necesario para cubrir otros casos

}