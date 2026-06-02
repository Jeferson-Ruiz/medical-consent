package com.jr.consentimiento.service;

import com.jr.consentimiento.dto.ModelEmailDto;

public interface IEmailService {

    void sendEmail(ModelEmailDto email, byte[] pdf);
}
