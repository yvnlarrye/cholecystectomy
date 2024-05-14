package com.cholecystectomy.domain.model.poll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clinical_part_records")
public class ClinicalPartRecord {

    @Id
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
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
