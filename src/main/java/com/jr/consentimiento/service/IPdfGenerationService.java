package com.jr.consentimiento.service;

import com.jr.consentimiento.dto.PdfRequestDTO;

public interface IPdfGenerationService {

    public byte[] generationPdf(PdfRequestDTO request) throws Exception;
}
