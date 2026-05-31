package com.jr.consentimiento.service;

public interface IHtmlToPdfService {

    public byte[] convertirHtmlAPdf(String html) throws Exception;
}
