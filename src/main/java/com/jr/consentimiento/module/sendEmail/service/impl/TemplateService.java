package com.jr.consentimiento.module.sendEmail.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jr.consentimiento.module.sendEmail.enums.ConsentType;
import com.jr.consentimiento.module.sendEmail.service.interfaces.ITemplateService;

@Service
public class TemplateService implements ITemplateService {

    private final TemplateEngine templateEngine;

    public TemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String processedTemplate(ConsentType type, Map<String, String> date) {
        Context context = new Context();
        context.setVariables(new HashMap<>(date));
        String nameTemplate = "consentimientos/" + type.getArchivo().replace(".html", "");
        return templateEngine.process(nameTemplate, context);
    }
}