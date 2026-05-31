package com.jr.consentimiento.service.impl;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.enums.ConsentType;
import com.jr.consentimiento.service.IValidationService;

@Service
public class ValidationService implements IValidationService {

    private static final String DANGEROUS_CHARACTERS = "[<>{}]";

    public ConsentType validateType(String type) {
        for (ConsentType consentType : ConsentType.values()) {
            if (consentType.name().equals(type)) {
                return consentType;
            }
        }
        throw new IllegalArgumentException("Tipo de consentimiento no válido: " + type);
    }

    public void validateData(Map<String, String> date) {
        date.forEach((fields, value) -> {
            if (value != null && value.matches(".*" + DANGEROUS_CHARACTERS + ".*")) {
                throw new IllegalArgumentException("El campo '" + fields + "' contiene caracteres no permitidos");
            }
        });
    }
}
