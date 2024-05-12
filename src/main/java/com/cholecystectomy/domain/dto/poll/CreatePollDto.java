package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePollDto {
    private Long patientId;
    private GeneralInformationDto generalInformation;
    private AnamnesisOfLifeDto anamnesisOfLife;
    private CholecystectomyDto cholecystectomy;
    private LaboratoryInstrumentalResearchMethodsDto laboratoryInstrumentalResearchMethods;
    private ClinicalPartDto clinicalPart;
}
