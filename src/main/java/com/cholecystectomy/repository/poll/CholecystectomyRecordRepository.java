package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.CholecystectomyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CholecystectomyRecordRepository extends JpaRepository<CholecystectomyRecord, Long> {

    @Query(
            value = """
                    SELECT COUNT(r.cholelithiasis_order)
                    FROM cholecystectomy_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex AND r.cholelithiasis_order = :order
                    """,
            nativeQuery = true
    )
    Long getCholelithiasisOrderCount(String sex, String order);

    @Query(
            value = """
                    SELECT COUNT(r.complications_chronic_endometritis)
                    FROM cholecystectomy_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex AND r.complications_chronic_endometritis = 'Да'
                    """,
            nativeQuery = true
    )
    Long getComplicationsChronicEndometritisCount(String sex);

    @Query(
            value = """
                    SELECT AVG(r.koyko_days)
                    FROM cholecystectomy_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex
                    """,
            nativeQuery = true
    )
    Double getAverageKoykoDays(String sex);

    @Query(
            value = """
                    SELECT COUNT(r.heredity_is_burdened_with_cholelithiasis)
                    FROM cholecystectomy_records r
                    JOIN polls p
                        ON r.id = p.id
                    JOIN users u
                        ON p.patient_id = u.id
                    WHERE u.sex = :sex AND r.heredity_is_burdened_with_cholelithiasis = 'Да'
                    """,
            nativeQuery = true
    )
    Long getHeredityIsBurdenedWithCholelithiasisCount(String sex);

}
