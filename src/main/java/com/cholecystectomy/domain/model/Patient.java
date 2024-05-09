package com.cholecystectomy.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@AllArgsConstructor
@Table(name = "patients")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Patient extends User {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Doctor doctor;

    public Patient() {
        super.setRole(Role.ROLE_PATIENT);
    }
}
