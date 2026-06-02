package com.jr.consentimiento.module.sendEmail.enums;

import lombok.Getter;

@Getter
public enum ConsentType {
    VACUNA("vacuna.html");

    private final String archivo;

    private ConsentType(String archivo) {
        this.archivo = archivo;
    }
}
