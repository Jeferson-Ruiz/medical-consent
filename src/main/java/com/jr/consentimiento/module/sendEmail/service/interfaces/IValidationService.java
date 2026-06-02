package com.jr.consentimiento.module.sendEmail.service.interfaces;

import java.util.Map;

import com.jr.consentimiento.module.sendEmail.enums.ConsentType;

public interface IValidationService {

    ConsentType validateType(String type);

    void validateData(Map<String, String> date);
}
