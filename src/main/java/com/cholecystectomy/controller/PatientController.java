package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.PatientsDoctorInfoDto;
import com.cholecystectomy.domain.dto.patient.PatientProfileDto;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.service.DoctorService;
import com.cholecystectomy.service.PatientService;
import com.cholecystectomy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientProfileDto> getPatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        Doctor doctor = patient.getDoctor();

        PatientsDoctorInfoDto doctorInfoDto = null;
        if (doctor != null) {
            doctorInfoDto = new PatientsDoctorInfoDto(doctor.getName(), doctor.getJob().getName());
        }

        PatientProfileDto patientProfileDto = PatientProfileDto.builder()
                .sex(patient.getSex().getName())
                .email(patient.getEmail())
                .name(patient.getName())
                .doctor(doctorInfoDto)
                .build();
        return ResponseEntity.ok(patientProfileDto);
    }


}
