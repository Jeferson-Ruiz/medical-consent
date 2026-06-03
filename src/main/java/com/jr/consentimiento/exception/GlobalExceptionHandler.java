package com.jr.consentimiento.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jr.consentimiento.module.sendEmail.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidacion(IllegalArgumentException ex) {
        return ResponseEntity
                .status(400)
                .body(new ErrorResponseDTO(400, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneral(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(new ErrorResponseDTO(500, ex.getMessage()));
    }
}
