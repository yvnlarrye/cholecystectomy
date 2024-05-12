package com.cholecystectomy.domain.model;

import com.cholecystectomy.domain.model.poll.Poll;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

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
    @JsonIgnore
    @JoinColumn(name = "doctor_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Doctor doctor;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Poll> polls;

    public Patient() {
        super.setRole(Role.ROLE_PATIENT);
    }
}
