package com.cholecystectomy.repository;

import com.cholecystectomy.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
//    @Query("SELECT p FROM Patient p WHERE p.doctor = null")
    List<Patient> findAllByDoctorIsNull();
}
