package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.doctor.CreateDoctorRequest;
import com.cholecystectomy.domain.dto.doctor.DoctorCreatedResponse;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Job;
import com.cholecystectomy.domain.model.Role;
import com.cholecystectomy.domain.model.User;
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


    public DoctorCreatedResponse createDoctor(CreateDoctorRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_DOCTOR)
                .build();
        User createdUser = userService.create(user);

        Job job = jobService.get(request.getJobId());
        doctorService.create(new Doctor(createdUser, job));
        return new DoctorCreatedResponse("Врач добавлен");
    }

}
