package com.cholecystectomy.domain.model.poll;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
@Builder
@Table(name = "anamnesis_of_life_records")
public class AnamnesisOfLifeRecord {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    private Poll poll;

    private String concomitantDiseases;
    private String smoking;
    private String alcoholAbuse;
    private String allergy;
}
