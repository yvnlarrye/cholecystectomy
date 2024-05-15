package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.StatisticDto;
import com.cholecystectomy.domain.model.Sex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final PollService pollService;


    public StatisticDto getTotalStatistic() {
        return StatisticDto.builder()
                .doctorsCount(doctorService.getDoctorsCount())
                .patientsCount(patientService.getPatientsCount())

                .malePatientsCount(patientService.getPatientsCountWithSex(Sex.MALE))
                .femalePatientsCount(patientService.getPatientsCountWithSex(Sex.FEMALE))

                .maleAvgAge(pollService.getAverageAgeWithSex(Sex.MALE))
                .femaleAvgAge(pollService.getAverageAgeWithSex(Sex.FEMALE))

                .maleAvgWeight(pollService.getAverageWeightBySex(Sex.MALE))
                .femaleAvgWeight(pollService.getAverageWeightBySex(Sex.FEMALE))

                .maleAvgHeight(pollService.getAverageHeightBySex(Sex.MALE))
                .femaleAvgHeight(pollService.getAverageHeightBySex(Sex.FEMALE))

                .maleAvgBodyMassIndex(pollService.getAverageBodyMaxIndexBySex(Sex.MALE))
                .femaleAvgBodyMassIndex(pollService.getAverageBodyMaxIndexBySex(Sex.FEMALE))

                .maleCountEmergencyCholelithiasisOrder(pollService.getCholelithiasisOrderCount(Sex.MALE, "Плановая"))
                .maleCountEmergencyCholelithiasisOrder(pollService.getCholelithiasisOrderCount(Sex.MALE, "Экстренная"))

                .femaleCountNonEmergencyCholelithiasisOrder(pollService.getCholelithiasisOrderCount(Sex.FEMALE, "Плановая"))
                .femaleCountNonEmergencyCholelithiasisOrder(pollService.getCholelithiasisOrderCount(Sex.FEMALE, "Экстренная"))

                .maleCountComplicationsChronicEndometritis(pollService.getComplicationsChronicEndometritisCount(Sex.MALE))
                .femaleCountComplicationsChronicEndometritis(pollService.getComplicationsChronicEndometritisCount(Sex.FEMALE))

                .maleAvgKoykoDays(pollService.getAverageKoykoDays(Sex.MALE))
                .femaleAvgKoykoDays(pollService.getAverageKoykoDays(Sex.FEMALE))

                .maleCountHeredityIsBurdenedWithCholelithiasis(pollService.getHeredityIsBurdenedWithCholelithiasisCount(Sex.MALE))
                .femaleCountHeredityIsBurdenedWithCholelithiasis(pollService.getHeredityIsBurdenedWithCholelithiasisCount(Sex.FEMALE))

                .maleAlivePatientsCount(pollService.getAlivePatientsCount(Sex.MALE))
                .femaleAlivePatientsCount(pollService.getAlivePatientsCount(Sex.FEMALE))

                .maleDeadPatientsCount(pollService.getDeadPatientsCount(Sex.MALE))
                .femaleDeadPatientsCount(pollService.getDeadPatientsCount(Sex.FEMALE))

                .build();
    }
}
