package com.jr.consentimiento.service;

import java.util.Map;
import com.jr.consentimiento.enums.ConsentType;

public interface ITemplateService {

    String processedTemplate(ConsentType type, Map<String, String> date);
}
