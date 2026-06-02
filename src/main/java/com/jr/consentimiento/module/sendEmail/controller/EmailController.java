package com.jr.consentimiento.module.sendEmail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jr.consentimiento.module.sendEmail.dto.ModelEmailDto;
import com.jr.consentimiento.module.sendEmail.service.interfaces.ISendEmailWithPdf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/consent/email")
public class EmailController {

    private final ISendEmailWithPdf sendEmailWithPdf;

    public EmailController(ISendEmailWithPdf sendEmailWithPdf) {
        this.sendEmailWithPdf = sendEmailWithPdf;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody ModelEmailDto email) throws Exception {
        sendEmailWithPdf.sendEamil(email);
        return ResponseEntity.ok("Correo enviado correctamente");
    }

}
