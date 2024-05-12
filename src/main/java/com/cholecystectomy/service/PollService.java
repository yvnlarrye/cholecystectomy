package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.poll.*;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.poll.*;
import com.cholecystectomy.repository.poll.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;
    private final GeneralInformationRecordRepository generalInformationRecordRepository;
    private final AnamnesisOfLifeRecordRepository anamnesisOfLifeRecordRepository;
    private final CholecystectomyRecordRepository cholecystectomyRecordRepository;
    private final ClinicalPartRecordRepository clinicalPartRecordRepository;
    private final LaboratoryInstrumentalResearchMethodsRecordRepository laboratoryInstrumentalResearchMethodsRecordRepository;

    private final PatientService patientService;

    public Poll create(Poll poll) {
        return pollRepository.save(poll);
    }


    private GeneralInformationRecord createGeneralInformation(GeneralInformationDto generalInformationDto, Poll poll) {
        GeneralInformationRecord generalInformationRecord = GeneralInformationRecord.builder()
                .poll(poll)
                .createdAt(new Date())
                .birthDate(generalInformationDto.getBirthDate())
                .age(generalInformationDto.getAge())
                .numberOfPregnancies(generalInformationDto.getNumberOfPregnancies())
                .numberOfChildbirths(generalInformationDto.getNumberOfChildbirths())
                .address(generalInformationDto.getAddress())
                .phoneNumber(generalInformationDto.getPhoneNumber())
                .weight(generalInformationDto.getWeight())
                .height(generalInformationDto.getHeight())
                .bodyMassIndex(generalInformationDto.getBodyMassIndex())
                .deathDate(generalInformationDto.getDeathDate())
                .build();
        return generalInformationRecordRepository.save(generalInformationRecord);
    }

    private AnamnesisOfLifeRecord createAnamnesisOfLife(AnamnesisOfLifeDto anamnesisOfLifeDto, Poll poll) {
        AnamnesisOfLifeRecord anamnesisOfLifeRecord = AnamnesisOfLifeRecord.builder()
                .poll(poll)
                .concomitantDiseases(anamnesisOfLifeDto.getConcomitantDiseases())
                .smoking(anamnesisOfLifeDto.getSmoking())
                .alcoholAbuse(anamnesisOfLifeDto.getAlcoholAbuse())
                .allergy(anamnesisOfLifeDto.getAllergy())
                .build();
        return anamnesisOfLifeRecordRepository.save(anamnesisOfLifeRecord);
    }

    private CholecystectomyRecord createCholecystectomy(CholecystectomyDto cholecystectomyDto, Poll poll) {
        CholecystectomyRecord cholecystectomyRecord = CholecystectomyRecord.builder()
                .poll(poll)
                .cholelithiasisDiagnosisDate(cholecystectomyDto.getCholelithiasisDiagnosisDate())
                .diseaseCourse(cholecystectomyDto.getDiseaseCourse())
                .surgeryType(cholecystectomyDto.getSurgeryType())
                .cholelithiasisOrder(cholecystectomyDto.getCholelithiasisOrder())
                .emergencyReason(cholecystectomyDto.getEmergencyReason())
                .complicationsChronicEndometritis(cholecystectomyDto.getComplicationsChronicEndometritis())
                .koykoDays(cholecystectomyDto.getKoykoDays())
                .descriptionOfMacropreparation(cholecystectomyDto.getDescriptionOfMacropreparation())
                .heredityIsBurdenedWithCholelithiasis(cholecystectomyDto.getHeredityIsBurdenedWithCholelithiasis())
                .build();
        return cholecystectomyRecordRepository.save(cholecystectomyRecord);
    }

    private ClinicalPartRecord createClinicalPart(ClinicalPartDto clinicalPartDto, Poll poll) {
        ClinicalPartRecord clinicalPartRecord = ClinicalPartRecord.builder()
                .poll(poll)
                .pain(clinicalPartDto.getPain())
                .localisation(clinicalPartDto.getLocalisation())
                .irradiation(clinicalPartDto.getIrradiation())
                .durance(clinicalPartDto.getDurance())
                .attacksOfBiliaryColic(clinicalPartDto.getAttacksOfBiliaryColic())
                .epigastricDiscomfort(clinicalPartDto.getEpigastricDiscomfort())
                .impairedToleranceToFattyFoods(clinicalPartDto.getImpairedToleranceToFattyFoods())
                .nausea(clinicalPartDto.getNausea())
                .vomiting(clinicalPartDto.getVomiting())
                .bitternessInTheMouth(clinicalPartDto.getBitternessInTheMouth())
                .constipation(clinicalPartDto.getConstipation())
                .diarrhea(clinicalPartDto.getDiarrhea())
                .heartburn(clinicalPartDto.getHeartburn())
                .sleepDisturbance(clinicalPartDto.getSleepDisturbance())
                .fever(clinicalPartDto.getFever())
                .build();
        return clinicalPartRecordRepository.save(clinicalPartRecord);
    }

    private LaboratoryInstrumentalResearchMethodsRecord createLaboratoryInstrumentalResearchMethods(LaboratoryInstrumentalResearchMethodsDto laboratoryInstrumentalResearchMethodsDto, Poll poll) {
        LaboratoryInstrumentalResearchMethodsRecord laboratoryInstrumentalResearchMethodsRecord = LaboratoryInstrumentalResearchMethodsRecord.builder()
                .poll(poll)
                .chestXray(laboratoryInstrumentalResearchMethodsDto.getChestXray())
                .chestXrayDeviations(laboratoryInstrumentalResearchMethodsDto.getChestXrayDeviations())
                .electrocardiography(laboratoryInstrumentalResearchMethodsDto.getElectrocardiography())
                .electrocardiographyDeviations(laboratoryInstrumentalResearchMethodsDto.getElectrocardiographyDeviations())
                .generalBloodAnalysis(laboratoryInstrumentalResearchMethodsDto.getGeneralBloodAnalysis())
                .hemoglobin(laboratoryInstrumentalResearchMethodsDto.getHemoglobin())
                .redBloodCells(laboratoryInstrumentalResearchMethodsDto.getRedBloodCells())
                .leukocytes(laboratoryInstrumentalResearchMethodsDto.getLeukocytes())
                .erythrocyteSedimentationRate(laboratoryInstrumentalResearchMethodsDto.getErythrocyteSedimentationRate())
                .generalUrineAnalysis(laboratoryInstrumentalResearchMethodsDto.getGeneralUrineAnalysis())
                .generalUrineAnalysisDeviations(laboratoryInstrumentalResearchMethodsDto.getGeneralUrineAnalysisDeviations())
                .bloodType(laboratoryInstrumentalResearchMethodsDto.getBloodType())
                .rhFactor(laboratoryInstrumentalResearchMethodsDto.getRhFactor())
                .biochemicalStudies(laboratoryInstrumentalResearchMethodsDto.getBiochemicalStudies())
                .cholesterol(laboratoryInstrumentalResearchMethodsDto.getCholesterol())
                .totalBilirubin(laboratoryInstrumentalResearchMethodsDto.getTotalBilirubin())
                .directBilirubin(laboratoryInstrumentalResearchMethodsDto.getDirectBilirubin())
                .indirectBilirubin(laboratoryInstrumentalResearchMethodsDto.getIndirectBilirubin())
                .alt(laboratoryInstrumentalResearchMethodsDto.getAlt())
                .ast(laboratoryInstrumentalResearchMethodsDto.getAst())
                .alkalinePhosphatase(laboratoryInstrumentalResearchMethodsDto.getAlkalinePhosphatase())
                .gammaGlutamylTransferase(laboratoryInstrumentalResearchMethodsDto.getGammaGlutamylTransferase())
                .serumGlucose(laboratoryInstrumentalResearchMethodsDto.getSerumGlucose())
                .fibrogastroduodenoscopy(laboratoryInstrumentalResearchMethodsDto.getFibrogastroduodenoscopy())
                .ultrasoundExaminationOfTheAbdominalOrgans(laboratoryInstrumentalResearchMethodsDto.getUltrasoundExaminationOfTheAbdominalOrgans())
                .build();
        return laboratoryInstrumentalResearchMethodsRecordRepository.save(laboratoryInstrumentalResearchMethodsRecord);
    }

    public Poll createFullPoll(CreatePollDto createPollDto) {
        Patient patient = patientService.getPatientById(createPollDto.getPatientId());
        Poll poll = create(new Poll(patient));

        createGeneralInformation(createPollDto.getGeneralInformation(), poll);
        createAnamnesisOfLife(createPollDto.getAnamnesisOfLife(), poll);
        createCholecystectomy(createPollDto.getCholecystectomy(), poll);
        createClinicalPart(createPollDto.getClinicalPart(), poll);
        createLaboratoryInstrumentalResearchMethods(createPollDto.getLaboratoryInstrumentalResearchMethods(), poll);

        return poll;
    }
}
