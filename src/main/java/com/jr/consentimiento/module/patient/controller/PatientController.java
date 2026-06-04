package com.jr.consentimiento.module.patient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jr.consentimiento.module.patient.dto.PatientRequestDto;
import com.jr.consentimiento.module.patient.dto.PatientRequestIdDto;
import com.jr.consentimiento.module.patient.dto.PatientResponseDto;
import com.jr.consentimiento.module.patient.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequestDto patientRequestDto){
        patientService.createPatient(patientRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getPatientByNumberId(@RequestBody PatientRequestIdDto request){
        PatientResponseDto patientDto = patientService.findPatientByNumberId(request.number());
        return ResponseEntity.ok(patientDto);
    }
}