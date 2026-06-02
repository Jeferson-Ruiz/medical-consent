package com.jr.consentimiento.service.impl;

import org.springframework.stereotype.Service;
import com.jr.consentimiento.dto.ModelEmailDto;
import com.jr.consentimiento.dto.PdfRequestDTO;
import com.jr.consentimiento.service.IEmailService;
import com.jr.consentimiento.service.IPdfGenerationService;
import com.jr.consentimiento.service.ISendEmailWithPdf;

@Service
public class SendEmailWithPdf implements ISendEmailWithPdf {
    private final IPdfGenerationService pdfGenerationService;
    private final IEmailService emailService;

    public SendEmailWithPdf(IPdfGenerationService pdfGenerationService, IEmailService emailService) {
        this.pdfGenerationService = pdfGenerationService;
        this.emailService = emailService;
    }

    @Override
    public void sendEamil(ModelEmailDto emailDto) throws Exception {
        PdfRequestDTO request = new PdfRequestDTO();
        request.setConsentType(emailDto.getConsentType());
        request.setData(emailDto.getData());

        byte[] pdf = pdfGenerationService.generationPdf(request);
        emailService.sendEmail(emailDto, pdf);
    }
}
