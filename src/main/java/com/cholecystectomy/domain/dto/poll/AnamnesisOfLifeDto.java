package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnamnesisOfLifeDto {
    private String concomitantDiseases;
    private String smoking;
    private String alcoholAbuse;
    private String allergy;
}
