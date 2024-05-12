package com.cholecystectomy.domain.model.poll;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
@Builder
@Table(name = "laboratory_instrumental_research_methods_records")
public class LaboratoryInstrumentalResearchMethodsRecord {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    private Poll poll;

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
