package com.cholecystectomy.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticDto {
    private Long patientsCount;
    private Long doctorsCount;

    private Long femalePatientsCount;
    private Long malePatientsCount;

    private Double maleAvgAge;
    private Double femaleAvgAge;

    private Double maleAvgHeight;
    private Double femaleAvgHeight;

    private Double maleAvgWeight;
    private Double femaleAvgWeight;

    private Double maleAvgBodyMassIndex;
    private Double femaleAvgBodyMassIndex;

    private Long maleCountEmergencyCholelithiasisOrder;
    private Long femaleCountEmergencyCholelithiasisOrder;

    private Long maleCountNonEmergencyCholelithiasisOrder;
    private Long femaleCountNonEmergencyCholelithiasisOrder;

    private Long maleCountComplicationsChronicEndometritis;
    private Long femaleCountComplicationsChronicEndometritis;

    private Double maleAvgKoykoDays;
    private Double femaleAvgKoykoDays;

    private Long maleCountHeredityIsBurdenedWithCholelithiasis;
    private Long femaleCountHeredityIsBurdenedWithCholelithiasis;

    private Long maleAlivePatientsCount;
    private Long femaleAlivePatientsCount;

    private Long maleDeadPatientsCount;
    private Long femaleDeadPatientsCount;
}
