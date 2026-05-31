package com.jr.consentimiento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jr.consentimiento.dto.ModelEmailDto;
import com.jr.consentimiento.service.IEmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/send-email")
public class EmailController {

    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestBody ModelEmailDto emailDto) throws MessagingException {
        emailService.sendEmail(emailDto);

        return new ResponseEntity<>("Correo enviado exitosament", HttpStatus.OK);
    }

}
