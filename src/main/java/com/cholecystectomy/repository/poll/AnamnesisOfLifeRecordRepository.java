package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.AnamnesisOfLifeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnamnesisOfLifeRecordRepository extends JpaRepository<AnamnesisOfLifeRecord, Long> {
}
