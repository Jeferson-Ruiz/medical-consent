package com.jr.consentimiento.service.impl;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.jr.consentimiento.dto.ModelEmailDto;
import com.jr.consentimiento.service.IEmailService;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(ModelEmailDto email, byte[] pdf) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email.getRecipient());
            helper.setSubject(email.getSubject());

            Context context = new Context();
            context.setVariable("message", email.getMessage());
            String contentHtml = templateEngine.process("model/modelEmail", context);
            helper.setText(contentHtml, true);

            // Adjunta el PDF
            helper.addAttachment(
                    "consentimiento.pdf",
                    new ByteArrayResource(pdf),
                    "application/pdf");

            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}
