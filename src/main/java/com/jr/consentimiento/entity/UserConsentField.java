package com.jr.consentimiento.entity;

import com.jr.consentimiento.enums.TypeIdentification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserConsentField {

    private Long id;
    private String userName;
    private String lastName;
    private TypeIdentification typeIdentification;
    private String numberId;
    private int age;
}
