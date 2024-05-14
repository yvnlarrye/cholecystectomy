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
@Table(name = "anamnesis_of_life_records")
public class AnamnesisOfLifeRecord {

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

    private String concomitantDiseases;
    private String smoking;
    private String alcoholAbuse;
    private String allergy;
}
