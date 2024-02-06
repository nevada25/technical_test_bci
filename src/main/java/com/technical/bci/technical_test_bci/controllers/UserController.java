package com.technical.bci.technical_test_bci.controllers;

import ch.qos.logback.classic.turbo.DuplicateMessageFilter;
import com.google.gson.Gson;
import com.sun.jdi.request.DuplicateRequestException;
import com.technical.bci.technical_test_bci.models.User;
import com.technical.bci.technical_test_bci.models.responseerror.ErrorMessage;
import com.technical.bci.technical_test_bci.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.*;
import org.hibernate.DuplicateMappingException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
        } catch (DataIntegrityViolationException r) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("El correo ya existe"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(e.getMessage()));
        }
    }
}