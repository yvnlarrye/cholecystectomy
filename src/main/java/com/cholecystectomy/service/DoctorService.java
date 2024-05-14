package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.doctor.CreateDoctorRequest;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.Role;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;
    private final JobService jobService;
    private final PasswordEncoder passwordEncoder;

    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Врач не найден"));
    }

    public List<Patient> getPatients(Long doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        return doctor.getPatients();
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }

    public Doctor createDoctor(CreateDoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setEmail(request.getEmail());
        doctor.setPassword(passwordEncoder.encode(request.getPassword()));
        doctor.setName(request.getName());
        doctor.setRole(Role.ROLE_DOCTOR);
        doctor.setJob(jobService.get(request.getJobId()));
        doctor.setSex(request.getSex());
        return create(doctor);
    }
}
