package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.LaboratoryInstrumentalResearchMethodsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryInstrumentalResearchMethodsRecordRepository extends JpaRepository<LaboratoryInstrumentalResearchMethodsRecord, Long> {
}
