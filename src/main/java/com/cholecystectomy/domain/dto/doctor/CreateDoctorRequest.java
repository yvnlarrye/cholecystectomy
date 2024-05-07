package com.cholecystectomy.domain.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDoctorRequest {
    private String email;
    private String password;
    private String name;
    private Long jobId;
}
