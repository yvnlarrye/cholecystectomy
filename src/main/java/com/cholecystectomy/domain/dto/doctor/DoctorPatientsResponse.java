package com.cholecystectomy.domain.dto.doctor;

import com.cholecystectomy.domain.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DoctorPatientsResponse {
    private List<Patient> patients;
}
