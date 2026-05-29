package com.jr.consentimiento.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import com.jr.consentimiento.enums.ConsentType;

@Service
public class TemplateService {

    private final TemplateEngine templateEngine;

    // Spring inyecta el TemplateEngine que él mismo configuró
    public TemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String processedTemplate(ConsentType type, Map<String, String> date) {
        Context context = new Context();
        context.setVariables(new HashMap<>(date));
        String nameTemplate = type.getArchivo().replace(".html", "");
        return templateEngine.process(nameTemplate, context);
    }
}