package com.jr.consentimiento.module.sendEmail.service.impl;

import org.springframework.stereotype.Service;

import com.jr.consentimiento.module.sendEmail.dto.ModelEmailDto;
import com.jr.consentimiento.module.sendEmail.dto.PdfRequestDTO;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IEmailService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.IPdfGenerationService;
import com.jr.consentimiento.module.sendEmail.service.interfaces.ISendEmailWithPdf;

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
