package com.jr.consentimiento.module.patient.dto;

import com.jr.consentimiento.module.patient.entity.Patient;
import com.jr.consentimiento.shared.enums.TypeIdentification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDto {
    private String name;
    private String lastName;
    private TypeIdentification typeIdentification;
    private String numberIdentification;
    private String phone;
    private String email;
    private String eps;

    public Patient toEntity() {
        Patient patient = new Patient();
        patient.setName(this.name);
        patient.setLastName(this.lastName);
        patient.setTypeIdentification(this.typeIdentification);
        patient.setNumberIdentification(this.numberIdentification);
        patient.setPhone(this.phone);
        patient.setEmail(this.email);
        patient.setEps(this.eps);
        return patient;
    }
}
