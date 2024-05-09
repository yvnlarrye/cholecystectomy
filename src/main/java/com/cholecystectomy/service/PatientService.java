package com.cholecystectomy.service;

import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пациент не найден"));
    }

    public void assignDoctor(Long patientId, Doctor doctor) {
        Patient patientToUpdate = getPatientById(patientId);
        patientToUpdate.setDoctor(doctor);
        repository.save(patientToUpdate);
    }

    public List<Patient> getAllPatientsWithNoDoctor() {
        return repository.findAllPatientsWithNoDoctor();
    }

}
