package com.technical.bci.technical_test_bci.controllers;

import com.technical.bci.technical_test_bci.exceptions.EmailAlreadyExistsException;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.models.responseerror.ErrorMessage;
import com.technical.bci.technical_test_bci.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@Tag(name = "Usuarios", description = "registro , actualizacion , listar y eliminancion de usuarios")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorMessage("El correo ya registrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage("Error interno del servidor" + e.getMessage()));
        }
    }
}