package com.jr.consentimiento.module.sendEmail.service.interfaces;

import java.util.Map;

import com.jr.consentimiento.module.sendEmail.enums.ConsentType;

public interface ITemplateService {

    String processedTemplate(ConsentType type, Map<String, String> date);
}
