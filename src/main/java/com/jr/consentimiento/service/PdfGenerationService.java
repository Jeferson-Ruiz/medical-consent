package com.jr.consentimiento.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.dto.PdfRequestDTO;
import com.jr.consentimiento.enums.ConsentType;

@Service
public class PdfGenerationService {
    private final ValidationService validationService;
    private final DataPreparationService preparationService;
    private final TemplateService templateService;
    private final HtmlToPdfService htmlToPdfService;

    public PdfGenerationService(ValidationService validationService, DataPreparationService preparationService,
            TemplateService templateService, HtmlToPdfService htmlToPdfService) {
        this.validationService = validationService;
        this.preparationService = preparationService;
        this.templateService = templateService;
        this.htmlToPdfService = htmlToPdfService;
    }

    public byte[] generationPdf(PdfRequestDTO request) throws Exception {
        ConsentType type = validationService.validateType(request.getConsentType());

        validationService.validateData(request.getData());

        Map<String, String> datos = preparationService.dateNull(request.getData());

        String html = templateService.processedTemplate(type, datos);

        return htmlToPdfService.convertirHtmlAPdf(html);
    }

}
