package com.jr.consentimiento.module.sendEmail.service.impl;

import java.util.Map;
import org.springframework.stereotype.Service;

import com.jr.consentimiento.module.sendEmail.dto.PdfRequestDTO;
import com.jr.consentimiento.module.sendEmail.enums.ConsentType;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IDataPreparationService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IHtmlToPdfService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IPdfGenerationService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.ITemplateService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IValidationService;

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
