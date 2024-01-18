package com.technical.bci.technical_test_bci;

import com.technical.bci.technical_test_bci.clients.config.JwtUtil;
import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.repositories.UserRepository;
import com.technical.bci.technical_test_bci.services.impl.UserServiceImpl;
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
    void testRegisterUserSuccess() throws EmailAlreadyExistsException {
        // Simula un usuario registrado exitosamente
        when(userRepository.findByEmail(any())).thenReturn(null);
        when(userRepository.save(any())).thenReturn(new User());

        // Ejecuta la prueba
        User user = new User();
        userService.registerUser(user);

        // Puedes agregar más verificaciones según tus necesidades específicas
    }

    @Test
    void testRegisterUserEmailAlreadyExists() {
        // Simula el caso en que el correo ya existe
        when(userRepository.findByEmail(any())).thenReturn(new User());

        // Ejecuta la prueba y espera una excepción
        assertThrows(EmailAlreadyExistsException.class, () -> userService.registerUser(new User()));

        // Puedes agregar más verificaciones según tus necesidades específicas
    }

    // Agrega más pruebas según sea necesario para cubrir otros casos

}