package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClinicalPartDto {
    private String pain;
    private String localisation;
    private String irradiation;
    private String durance;
    private String attacksOfBiliaryColic;
    private String epigastricDiscomfort;
    private String impairedToleranceToFattyFoods;
    private String nausea;
    private String vomiting;
    private String bitternessInTheMouth;
    private String constipation;
    private String diarrhea;
    private String heartburn;
    private String sleepDisturbance;
    private String fever;
}
