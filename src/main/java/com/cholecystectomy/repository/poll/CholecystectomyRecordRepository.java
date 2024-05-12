package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.CholecystectomyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CholecystectomyRecordRepository extends JpaRepository<CholecystectomyRecord, Long> {
}
