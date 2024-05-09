package com.cholecystectomy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserService userService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final JobService jobService;
    private final PasswordEncoder passwordEncoder;


}
