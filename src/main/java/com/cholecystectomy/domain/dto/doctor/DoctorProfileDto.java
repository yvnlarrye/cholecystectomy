package com.cholecystectomy.domain.dto.doctor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorProfileDto {
    private String email;
    private String name;
    private String sex;
}
