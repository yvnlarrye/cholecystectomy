package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.*;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.service.DoctorService;
import com.cholecystectomy.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @PutMapping("/assign")
    public ResponseEntity<AssignDoctorResponse> assignDoctorToPatient(@RequestBody AssignDoctorDto request) {
        Doctor doctor = doctorService.getDoctorById(request.getDoctorId());
        patientService.assignDoctor(request.getPatientId(), doctor);
        return ResponseEntity.ok(new AssignDoctorResponse("Врач успешно прикреплен к пациенту"));
    }

    @PutMapping("/unassign")
    public ResponseEntity<AssignDoctorResponse> unassignDoctorToPatient(@RequestBody UnassignDoctorDto request) {
        patientService.unassignDoctor(request.getPatientId());
        return ResponseEntity.ok(new AssignDoctorResponse("Врач успешно откреплен от пациента"));
    }

    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<PatientsResponse> getPatients(@PathVariable Long doctorId) {
        return ResponseEntity.ok(new PatientsResponse(doctorService.getPatients(doctorId)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorProfileDto> getDoctorProfile(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        DoctorProfileDto profile = DoctorProfileDto.builder()
                .sex(doctor.getSex().getName())
                .email(doctor.getEmail())
                .name(doctor.getName())
                .build();
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/allow-poll/{patientId}")
    public ResponseEntity<Map<String, String>> allowPoll(@PathVariable Long patientId) {
        patientService.allowPoll(patientId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Доступ к прохождению опроса выдан");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/prohibit-poll/{patientId}")
    public ResponseEntity<Map<String, String>> prohibitPoll(@PathVariable Long patientId) {
        patientService.prohibitPoll(patientId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Доступ к прохождению опроса закрыт");
        return ResponseEntity.ok(response);
    }
}
