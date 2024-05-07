package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.doctor.CreateDoctorRequest;
import com.cholecystectomy.domain.dto.doctor.DoctorCreatedResponse;
import com.cholecystectomy.service.AdminService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("doctor")
    public ResponseEntity<DoctorCreatedResponse> createDoctor(@RequestBody CreateDoctorRequest doctor) {
        return ResponseEntity.ok(adminService.createDoctor(doctor));
    }

}
