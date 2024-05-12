package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.GeneralInformationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralInformationRecordRepository extends JpaRepository<GeneralInformationRecord, Long> {
}
