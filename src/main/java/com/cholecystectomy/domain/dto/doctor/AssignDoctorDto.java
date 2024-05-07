package com.cholecystectomy.domain.dto.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AssignDoctorDto {
    @JsonProperty("patient_id")
    private Long patientId;

    @JsonProperty("doctor_id")
    private Long doctorId;
}
