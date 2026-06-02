
package com.jr.consentimiento.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelEmailDto {
    private String recipient;
    private String subject;
    private String message;
    private String consentType;
    private Map<String, String> data;
}
