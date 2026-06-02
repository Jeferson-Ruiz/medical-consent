package com.jr.consentimiento.module.sendEmail.service.interfaces;

import com.jr.consentimiento.module.sendEmail.dto.ModelEmailDto;

public interface ISendEmailWithPdf {

    void sendEamil(ModelEmailDto emailDto) throws Exception;
}
