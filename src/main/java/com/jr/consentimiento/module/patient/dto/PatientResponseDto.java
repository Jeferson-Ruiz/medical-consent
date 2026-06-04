package com.jr.consentimiento.module.patient.dto;

import com.jr.consentimiento.module.patient.entity.Patient;
import com.jr.consentimiento.shared.enums.TypeIdentification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponseDto{
    private String name;
    private String lastName;
    private TypeIdentification typeIdentification;
    private String numberIdentification;
    private String phone;
    private String email;
    private String eps;
    
    public static PatientResponseDto toDto(Patient entity){
        PatientResponseDto tDto = new PatientResponseDto();
        tDto.setName(entity.getName());
        tDto.setLastName(entity.getLastName());
        tDto.setTypeIdentification(entity.getTypeIdentification());
        tDto.setNumberIdentification(entity.getNumberIdentification());
        tDto.setPhone(entity.getPhone());
        tDto.setEmail(entity.getEmail());
        tDto.setEps(entity.getEps());
        return tDto;
    }   
}