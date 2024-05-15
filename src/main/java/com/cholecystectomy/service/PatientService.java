package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.poll.PollDto;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.Sex;
import com.cholecystectomy.domain.model.poll.*;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;
    private final PollService pollService;

    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пациент не найден"));
    }

    public void assignDoctor(Long patientId, Doctor doctor) {
        Patient patientToUpdate = getPatientById(patientId);
        patientToUpdate.setDoctor(doctor);
        repository.save(patientToUpdate);
    }

    public void unassignDoctor(Long patientId) {
        Patient patientToUpdate = getPatientById(patientId);
        patientToUpdate.setDoctor(null);
        repository.save(patientToUpdate);
    }

    public List<Patient> getAllPatientsWithNoDoctor() {
        return repository.findAllByDoctorIsNull();
    }

    public List<PollDto> getPatientPolls(Long id) {
        List<Poll> polls = pollService.getAllPatientPolls(id);
        List<PollDto> pollDtoList = new ArrayList<>();
        for (Poll poll : polls) {
            GeneralInformationRecord generalInformationRecord =
                    pollService.getGeneralInformationRecord(poll.getId());

            CholecystectomyRecord cholecystectomyRecord =
                    pollService.getCholecystectomyRecord(poll.getId());
            AnamnesisOfLifeRecord anamnesisOfLifeRecord =
                    pollService.getAnamnesisOfLifeRecord(poll.getId());
            ClinicalPartRecord clinicalPartRecord =
                    pollService.getClinicalPartRecord(poll.getId());
            LaboratoryInstrumentalResearchMethodsRecord laboratoryInstrumentalResearchMethodsRecord = pollService.getLaboratoryInstrumentalResearchMethodsRecord(poll.getId());
            String[] patientNameParts = poll.getPatient().getName().split(" ");

            pollDtoList.add(PollDto
                    .builder()
                    .id(poll.getId())
                    .patientId(poll.getPatient().getId())
                    .surname(patientNameParts[0])
                    .firstName(patientNameParts[1])
                    .fatherName(patientNameParts[2])
                    .sex(poll.getPatient().getSex().getName())
                    .generalInformation(generalInformationRecord)
                    .anamnesisOfLife(anamnesisOfLifeRecord)
                    .cholecystectomy(cholecystectomyRecord)
                    .clinicalPart(clinicalPartRecord)
                    .laboratoryInstrumentalResearchMethods(laboratoryInstrumentalResearchMethodsRecord)
                    .build()
            );
        }
        return pollDtoList;
    }

    public void allowPoll(Long patientId) {
        Patient patient = getPatientById(patientId);
        patient.setIsPollAvailable(true);
        repository.save(patient);
    }

    public void prohibitPoll(Long patientId) {
        Patient patient = getPatientById(patientId);
        patient.setIsPollAvailable(false);
        repository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Long getPatientsCountWithSex(Sex sex) {
        return repository.countBySex(sex.name());
    }

    public Long getPatientsCount() {
        return repository.count();
    }

}
