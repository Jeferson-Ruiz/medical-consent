package com.jr.consentimiento.module.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jr.consentimiento.module.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
