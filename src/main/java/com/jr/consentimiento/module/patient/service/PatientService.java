package com.jr.consentimiento.module.patient.service;

import org.springframework.stereotype.Service;
import com.jr.consentimiento.module.patient.dto.PatientRequestDto;
import com.jr.consentimiento.module.patient.dto.PatientResponseDto;
import com.jr.consentimiento.module.patient.entity.Patient;
import com.jr.consentimiento.module.patient.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void createPatient(PatientRequestDto patientDto) {
        existByNumberId(patientDto.getNumberIdentification());
        Patient patient = patientDto.toEntity();
        patientRepository.save(patient);
    }

    @Override
    public PatientResponseDto findPatientByNumberId(String number){
        Patient patient = patientRepository.findByNumberIdentification(number)
            .orElseThrow(() -> new EntityNotFoundException());
        PatientResponseDto patientDto = PatientResponseDto.toDto(patient);
        return patientDto;
    }

    // helper
    private void existByNumberId(String number) {
        if (patientRepository.existsByNumberIdentification(number)) {
            throw new IllegalArgumentException("Numero de identificacion ya registrado");
        }
    }
}
