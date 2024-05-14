package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.CreateDoctorRequest;
import com.cholecystectomy.domain.dto.doctor.DoctorsResponse;
import com.cholecystectomy.domain.dto.doctor.PatientsResponse;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.service.DoctorService;
import com.cholecystectomy.service.PatientService;
import com.cholecystectomy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final UserService userService;

    @PostMapping("/doctor")
    public ResponseEntity<Map<String, String>> createDoctor(@RequestBody CreateDoctorRequest doctor) {
        doctorService.createDoctor(doctor);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Врач успешно добавлен");

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Врач успешно удалён");

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/doctors")
    public ResponseEntity<DoctorsResponse> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(new DoctorsResponse(doctors));
    }

    @GetMapping("/patients")
    public ResponseEntity<PatientsResponse> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(new PatientsResponse(patients));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Пользователь успешно удален");
        return ResponseEntity.ok(response);
    }



}
