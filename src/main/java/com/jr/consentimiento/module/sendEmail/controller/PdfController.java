package com.jr.consentimiento.module.sendEmail.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jr.consentimiento.module.sendEmail.dto.PdfRequestDTO;
import com.jr.consentimiento.module.sendEmail.service.impl.PdfGenerationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/consent/pdf")
public class PdfController {

    private final PdfGenerationService pdfService;

    public PdfController(PdfGenerationService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> pdfGeneration(@RequestBody @Valid PdfRequestDTO request) throws Exception {
        byte[] pdf = pdfService.generationPdf(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "consentimiento.pdf");

        return ResponseEntity.ok().headers(headers).body(pdf);
    }

}
