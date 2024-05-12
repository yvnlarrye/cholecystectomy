package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CholecystectomyDto {
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
