package com.cholecystectomy.domain.model.poll;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

import java.util.Date;

@Entity
@Builder
@Table(name = "general_information_records")
public class GeneralInformationRecord {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    private Poll poll;

    private Date createdAt;
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
