package com.cholecystectomy.domain.model.poll;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
@Builder
@Table(name = "clinical_part_records")
public class ClinicalPartRecord {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    private Poll poll;

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
