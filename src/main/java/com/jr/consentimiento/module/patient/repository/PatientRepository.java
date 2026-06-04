package com.jr.consentimiento.module.patient.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jr.consentimiento.module.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByNumberIdentification(String number);

    Optional<Patient> findByNumberIdentification(String number);
}
