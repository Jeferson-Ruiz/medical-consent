package com.jr.consentimiento.service;

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

    public TemplateService() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("template/consentimientos/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public String processedTemplate(ConsentType type, Map<String, Object> date) {
        Context context = new Context();
        context.setVariables(date);
        String nameTemplate = type.getArchivo().replace(".html", "");
        return templateEngine.process(nameTemplate, context);
    }
}