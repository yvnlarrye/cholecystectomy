package com.cholecystectomy.domain.model.poll;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

import java.util.Date;

@Entity
@Builder
@Table(name = "cholecystectomy_records")
public class CholecystectomyRecord {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
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
