package com.cholecystectomy.repository;

import com.cholecystectomy.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByDoctorIsNull();

    @Query(
            value = """
                    SELECT COUNT(u.sex)
                    FROM patients p
                    JOIN users u ON p.id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Long countBySex(String sex);
}
