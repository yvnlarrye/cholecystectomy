package com.cholecystectomy.domain.model.poll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@Data
@Table(name = "general_information_records")
public class GeneralInformationRecord {

    @Id
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public GeneralInformationRecord() {
        createdAt = new Date();
    }
}
