package com.jr.consentimiento.module.sendEmail.service.interfaces;

import com.jr.consentimiento.module.sendEmail.dto.PdfRequestDTO;

public interface IPdfGenerationService {

    public byte[] generationPdf(PdfRequestDTO request) throws Exception;
}
