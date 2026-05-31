
package com.jr.consentimiento.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelEmailDto {
    private String recipient;
    private String subject;
    private String message;
}
