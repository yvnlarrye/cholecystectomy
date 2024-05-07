package com.cholecystectomy.service;

import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

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

}
