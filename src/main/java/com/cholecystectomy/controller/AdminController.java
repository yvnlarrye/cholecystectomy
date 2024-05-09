package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.CreateDoctorRequest;
import com.cholecystectomy.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final DoctorService doctorService;

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

}
