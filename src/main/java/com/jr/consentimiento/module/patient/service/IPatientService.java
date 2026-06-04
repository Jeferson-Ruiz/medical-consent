package com.jr.consentimiento.module.patient.service;

import com.jr.consentimiento.module.patient.dto.PatientRequestDto;
import com.jr.consentimiento.module.patient.dto.PatientResponseDto;

public interface IPatientService {

    void createPatient(PatientRequestDto patientDto);

    PatientResponseDto findPatientByNumberId(String number);
}
