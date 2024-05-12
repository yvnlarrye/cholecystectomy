package com.cholecystectomy.domain.dto.poll;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GeneralInformationDto {
    private Date birthDate;
    private int age;

    private int numberOfPregnancies;
    private int numberOfChildbirths;
    private String address;
    private String phoneNumber;
    private int height;
    private int weight;
    private Double bodyMassIndex;
    private Date deathDate;
}
