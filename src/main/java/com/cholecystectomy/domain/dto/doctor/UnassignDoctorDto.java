package com.cholecystectomy.domain.dto.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnassignDoctorDto {
    @JsonProperty("patient_id")
    private Long patientId;
}
