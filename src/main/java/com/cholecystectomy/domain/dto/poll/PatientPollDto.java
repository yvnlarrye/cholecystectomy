package com.cholecystectomy.domain.dto.poll;

import com.cholecystectomy.domain.model.poll.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientPollDto {
    private Long id;
    private String surname;
    private String firstName;
    private String fatherName;
    private String sex;
    private GeneralInformationRecord generalInformation;
    private AnamnesisOfLifeRecord anamnesisOfLife;
    private CholecystectomyRecord cholecystectomy;
    private LaboratoryInstrumentalResearchMethodsRecord laboratoryInstrumentalResearchMethods;
    private ClinicalPartRecord clinicalPart;
}
