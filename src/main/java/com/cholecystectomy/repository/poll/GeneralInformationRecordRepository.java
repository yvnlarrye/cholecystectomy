package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.Sex;
import com.cholecystectomy.domain.model.poll.GeneralInformationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralInformationRecordRepository extends JpaRepository<GeneralInformationRecord, Long> {
    @Query(
            value = """
                    SELECT AVG(r.age)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Double getAverageAgeBySex(String sex);

    @Query(
            value = """
                    SELECT AVG(r.weight)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Double getAverageWeightBySex(String sex);

    @Query(
            value = """
                    SELECT AVG(r.height)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Double getAverageHeightBySex(String sex);

    @Query(
            value = """
                    SELECT AVG(r.body_mass_index)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Double getAverageBodyMaxIndexBySex(String sex);

    @Query(
            value = """
                    SELECT COUNT(r.death_date)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex AND r.death_date IS NULL
                    """,
            nativeQuery = true
    )
    Long getAlivePatientsCount(String sex);

    @Query(
            value = """
                    SELECT COUNT(r.death_date)
                    FROM general_information_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex AND r.death_date IS NOT NULL
                    """,
            nativeQuery = true
    )
    Long getDeadPatientsCount(String sex);
}
