package com.cholecystectomy.domain.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientsDoctorInfoDto {
    private String name;
    private String jobName;
}
