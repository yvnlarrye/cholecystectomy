package com.cholecystectomy.domain.dto.doctor;

import com.cholecystectomy.domain.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DoctorsResponse {
    private List<Doctor> doctors;
}
