package com.cholecystectomy.domain.dto.doctor;

import com.cholecystectomy.domain.model.Sex;
import lombok.Data;

@Data
public class CreateDoctorRequest {
    private String email;
    private String password;
    private String name;
    private Long jobId;
    private Sex sex;
}
