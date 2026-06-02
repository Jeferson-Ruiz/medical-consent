package com.jr.consentimiento.module.sendEmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private int status;
    private String messaje;
}
