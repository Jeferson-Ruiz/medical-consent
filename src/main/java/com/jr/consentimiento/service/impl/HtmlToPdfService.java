package com.jr.consentimiento.service.impl;

import java.io.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.service.IHtmlToPdfService;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class HtmlToPdfService implements IHtmlToPdfService {

    public byte[] convertirHtmlAPdf(String html) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String baseUri = getClass().getResource("/static/").toURI().toString();

        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(html, baseUri);
        builder.toStream(outputStream);
        builder.run();

        return outputStream.toByteArray();
    }
}
