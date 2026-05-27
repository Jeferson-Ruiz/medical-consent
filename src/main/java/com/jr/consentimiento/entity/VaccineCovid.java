package com.jr.consentimiento.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jr.consentimiento.enums.TypeIdentification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VaccineCovid {
    private String city;
    private LocalDateTime dateConsent;
    private LocalDate dateBirth;
    private String EAPBResponsible;
    private String nameVaccine;
    private boolean acceptTerms;
    private String reasondenial;

    // Represntante Legal
    private String namelegalRepresentative;
    private String lastNameRepresentative;
    private TypeIdentification typeIdRepresentative;
    private String numberIdRepresentative;

    // Vacunador
    private String nameVaccinator;
    private String lastVaccinator;
    private TypeIdentification tipeIdVaccinator;
    private String nameIdVaccinator;

    // pocision geografica
    private String nameIps;
    private String state;
    private String municipality;
}
