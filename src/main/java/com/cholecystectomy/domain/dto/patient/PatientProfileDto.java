package com.cholecystectomy.domain.dto.patient;

import com.cholecystectomy.domain.dto.doctor.PatientsDoctorInfoDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientProfileDto {
    private String name;
    private String email;
    private String sex;
    private PatientsDoctorInfoDto doctor;
}
