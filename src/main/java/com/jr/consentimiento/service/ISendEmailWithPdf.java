package com.jr.consentimiento.service;

import com.jr.consentimiento.dto.ModelEmailDto;

public interface ISendEmailWithPdf {

    void sendEamil(ModelEmailDto emailDto) throws Exception;
}
