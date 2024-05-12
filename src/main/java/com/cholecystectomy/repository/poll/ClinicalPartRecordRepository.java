package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.ClinicalPartRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalPartRecordRepository extends JpaRepository<ClinicalPartRecord, Long> {
}
