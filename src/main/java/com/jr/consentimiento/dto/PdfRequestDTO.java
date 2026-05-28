package com.jr.consentimiento.dto;

import java.util.Map;
import com.jr.consentimiento.enums.ConsentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdfRequestDTO {
    private ConsentType consentType;
    private Map<String, Object> data;
}
