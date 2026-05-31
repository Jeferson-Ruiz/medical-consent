package com.jr.consentimiento.service.impl;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.dto.PdfRequestDTO;
import com.jr.consentimiento.enums.ConsentType;
import com.jr.consentimiento.service.IDataPreparationService;
import com.jr.consentimiento.service.IHtmlToPdfService;
import com.jr.consentimiento.service.IPdfGenerationService;
import com.jr.consentimiento.service.ITemplateService;
import com.jr.consentimiento.service.IValidationService;

@Service
public class PdfGenerationService implements IPdfGenerationService {
    private final IValidationService validationService;
    private final IDataPreparationService preparationService;
    private final ITemplateService templateService;
    private final IHtmlToPdfService htmlToPdfService;

    public PdfGenerationService(IValidationService validationService, IDataPreparationService preparationService,
            ITemplateService templateService, IHtmlToPdfService htmlToPdfService) {
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
