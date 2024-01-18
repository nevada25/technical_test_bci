package com.technical.bci.technical_test_bci.models.responseerror;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> errors;

    // constructor, getters y setters
}