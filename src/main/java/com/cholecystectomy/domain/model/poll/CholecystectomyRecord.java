package com.cholecystectomy.domain.model.poll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cholecystectomy_records")
public class CholecystectomyRecord {

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

    private Date cholelithiasisDiagnosisDate;
    private String diseaseCourse;
    private String surgeryType;
    private String cholelithiasisOrder;
    private String emergencyReason;
    private String complicationsChronicEndometritis;
    private int koykoDays;
    private String descriptionOfMacropreparation;
    private String heredityIsBurdenedWithCholelithiasis;
}
