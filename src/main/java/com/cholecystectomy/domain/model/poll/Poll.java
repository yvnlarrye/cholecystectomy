package com.cholecystectomy.domain.model.poll;

import com.cholecystectomy.domain.model.Patient;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
//@Builder
@NoArgsConstructor
@Table(name = "polls")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Poll(Patient patient) {
        this.patient = patient;
    }

    //    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
//    private GeneralInformation generalInformation;
//
//    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
//    private AnamnesisOfLife anamnesisOfLife;
//
//    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
//    private Cholecystectomy cholecystectomy;
//
//    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
//    private ClinicalPart clinicalPart;
//
//    @OneToOne(mappedBy = "poll", cascade = CascadeType.ALL)
//    private LaboratoryInstrumentalResearchMethods laboratoryInstrumentalResearchMethods;

}
