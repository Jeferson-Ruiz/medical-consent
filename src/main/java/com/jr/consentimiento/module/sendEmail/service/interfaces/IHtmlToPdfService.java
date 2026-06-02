package com.jr.consentimiento.module.sendEmail.service.interfaces;

public interface IHtmlToPdfService {

    public byte[] convertirHtmlAPdf(String html) throws Exception;
}
