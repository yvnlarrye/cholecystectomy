package com.cholecystectomy.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userDetails;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Doctor(User userDetails, Job job) {
        this.userDetails = userDetails;
        this.job = job;
    }
}
