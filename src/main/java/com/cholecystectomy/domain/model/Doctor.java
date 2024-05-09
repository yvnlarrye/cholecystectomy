package com.cholecystectomy.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Data
@Builder
@Table(name = "doctors")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @NotNull
    private Job job;

    public Doctor() {
        super.setRole(Role.ROLE_DOCTOR);
    }

}
