package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.AssignDoctorDto;
import com.cholecystectomy.domain.dto.doctor.AssignDoctorResponse;
import com.cholecystectomy.domain.dto.doctor.DoctorPatientsResponse;
import com.cholecystectomy.domain.dto.doctor.DoctorProfileDto;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.service.DoctorService;
import com.cholecystectomy.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<DoctorPatientsResponse> getPatients(@PathVariable Long doctorId) {
        return ResponseEntity.ok(new DoctorPatientsResponse(doctorService.getPatients(doctorId)));
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


}
