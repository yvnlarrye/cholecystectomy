package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaboratoryInstrumentalResearchMethodsDto {
    private String chestXray;
    private String chestXrayDeviations;
    private String electrocardiography;
    private String electrocardiographyDeviations;
    private String generalBloodAnalysis;
    private String hemoglobin;
    private String redBloodCells;
    private String leukocytes;
    private String erythrocyteSedimentationRate;
    private String generalUrineAnalysis;
    private String generalUrineAnalysisDeviations;
    private String bloodType;
    private String rhFactor;
    private String biochemicalStudies;
    private String cholesterol;
    private String totalBilirubin;
    private String directBilirubin;
    private String indirectBilirubin;
    private String alt;
    private String ast;
    private String alkalinePhosphatase;
    private String gammaGlutamylTransferase;
    private String serumGlucose;
    private String fibrogastroduodenoscopy;
    private String ultrasoundExaminationOfTheAbdominalOrgans;
}
