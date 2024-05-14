package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.PatientsDoctorInfoDto;
import com.cholecystectomy.domain.dto.doctor.PatientsResponse;
import com.cholecystectomy.domain.dto.patient.PatientProfileDto;
import com.cholecystectomy.domain.dto.poll.PollDto;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                .isPollAvailable(patient.getIsPollAvailable())
                .doctor(doctorInfoDto)
                .build();
        return ResponseEntity.ok(patientProfileDto);
    }

    @GetMapping("/all/unassigned")
    public ResponseEntity<PatientsResponse> getPatientsWithUnassignedDoctor() {
        List<Patient> patientsWithNoDoctor = patientService.getAllPatientsWithNoDoctor();
        return ResponseEntity.ok(new PatientsResponse(patientsWithNoDoctor));
    }

    @GetMapping("/{id}/polls")
    public ResponseEntity<Map<String, List<PollDto>>> getPatientPolls(@PathVariable Long id) {
        Map<String, List<PollDto>> response = new HashMap<>();
        response.put("polls", patientService.getPatientPolls(id));
        return ResponseEntity.ok(response);
    }
}
