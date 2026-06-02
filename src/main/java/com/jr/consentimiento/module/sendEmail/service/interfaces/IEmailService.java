package com.jr.consentimiento.module.sendEmail.service.interfaces;

import com.jr.consentimiento.module.sendEmail.dto.ModelEmailDto;

public interface IEmailService {

    void sendEmail(ModelEmailDto email, byte[] pdf);
}
