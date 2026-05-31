package com.jr.consentimiento.service;

import java.util.Map;
import com.jr.consentimiento.enums.ConsentType;

public interface IValidationService {

    ConsentType validateType(String type);

    void validateData(Map<String, String> date);
}
