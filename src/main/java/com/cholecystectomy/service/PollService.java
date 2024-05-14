package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.poll.*;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.poll.*;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.poll.*;
import com.cholecystectomy.service.poll.serializer.PollSerializerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;
    private final GeneralInformationRecordRepository generalInformationRecordRepository;
    private final AnamnesisOfLifeRecordRepository anamnesisOfLifeRecordRepository;
    private final CholecystectomyRecordRepository cholecystectomyRecordRepository;
    private final ClinicalPartRecordRepository clinicalPartRecordRepository;
    private final LaboratoryInstrumentalResearchMethodsRecordRepository laboratoryInstrumentalResearchMethodsRecordRepository;
    private final PollSerializerService pollSerializerService;

    public Poll create(Poll poll) {
        return pollRepository.save(poll);
    }


    private GeneralInformationRecord saveGeneralInformation(
            GeneralInformationDto generalInformationDto,
            GeneralInformationRecord record,
            Poll poll
    ) {
        record.setPoll(poll);
        record.setBirthDate(generalInformationDto.getBirthDate());
        record.setAge(generalInformationDto.getAge());
        record.setNumberOfPregnancies(generalInformationDto.getNumberOfPregnancies());
        record.setNumberOfChildbirths(generalInformationDto.getNumberOfChildbirths());
        record.setAddress(generalInformationDto.getAddress());
        record.setPhoneNumber(generalInformationDto.getPhoneNumber());
        record.setWeight(generalInformationDto.getWeight());
        record.setHeight(generalInformationDto.getHeight());
        record.setBodyMassIndex(generalInformationDto.getBodyMassIndex());
        record.setDeathDate(generalInformationDto.getDeathDate());

        return generalInformationRecordRepository.save(record);
    }

    private AnamnesisOfLifeRecord saveAnamnesisOfLife(
            AnamnesisOfLifeDto anamnesisOfLifeDto, AnamnesisOfLifeRecord record, Poll poll
    ) {
        record.setPoll(poll);
        record.setConcomitantDiseases(anamnesisOfLifeDto.getConcomitantDiseases());
        record.setSmoking(anamnesisOfLifeDto.getSmoking());
        record.setAlcoholAbuse(anamnesisOfLifeDto.getAlcoholAbuse());
        record.setAllergy(anamnesisOfLifeDto.getAllergy());
        return anamnesisOfLifeRecordRepository.save(record);
    }

    private CholecystectomyRecord saveCholecystectomy(
            CholecystectomyDto cholecystectomyDto, CholecystectomyRecord record, Poll poll
    ) {
        record.setPoll(poll);
        record.setCholelithiasisDiagnosisDate(cholecystectomyDto.getCholelithiasisDiagnosisDate());
        record.setDiseaseCourse(cholecystectomyDto.getDiseaseCourse());
        record.setSurgeryType(cholecystectomyDto.getSurgeryType());
        record.setCholelithiasisOrder(cholecystectomyDto.getCholelithiasisOrder());
        record.setEmergencyReason(cholecystectomyDto.getEmergencyReason());
        record.setComplicationsChronicEndometritis(cholecystectomyDto.getComplicationsChronicEndometritis());
        record.setKoykoDays(cholecystectomyDto.getKoykoDays());
        record.setDescriptionOfMacropreparation(cholecystectomyDto.getDescriptionOfMacropreparation());
        record.setHeredityIsBurdenedWithCholelithiasis(cholecystectomyDto.getHeredityIsBurdenedWithCholelithiasis());

        return cholecystectomyRecordRepository.save(record);
    }

    private ClinicalPartRecord saveClinicalPart(
            ClinicalPartDto clinicalPartDto, ClinicalPartRecord record, Poll poll
    ) {
        record.setPoll(poll);
        record.setPain(clinicalPartDto.getPain());
        record.setLocalisation(clinicalPartDto.getLocalisation());
        record.setIrradiation(clinicalPartDto.getIrradiation());
        record.setDurance(clinicalPartDto.getDurance());
        record.setAttacksOfBiliaryColic(clinicalPartDto.getAttacksOfBiliaryColic());
        record.setEpigastricDiscomfort(clinicalPartDto.getEpigastricDiscomfort());
        record.setImpairedToleranceToFattyFoods(clinicalPartDto.getImpairedToleranceToFattyFoods());
        record.setNausea(clinicalPartDto.getNausea());
        record.setVomiting(clinicalPartDto.getVomiting());
        record.setBitternessInTheMouth(clinicalPartDto.getBitternessInTheMouth());
        record.setConstipation(clinicalPartDto.getConstipation());
        record.setDiarrhea(clinicalPartDto.getDiarrhea());
        record.setHeartburn(clinicalPartDto.getHeartburn());
        record.setSleepDisturbance(clinicalPartDto.getSleepDisturbance());
        record.setFever(clinicalPartDto.getFever());

        return clinicalPartRecordRepository.save(record);
    }

    private LaboratoryInstrumentalResearchMethodsRecord saveLaboratoryInstrumentalResearchMethods(
            LaboratoryInstrumentalResearchMethodsDto laboratoryInstrumentalResearchMethodsDto,
            LaboratoryInstrumentalResearchMethodsRecord record,
            Poll poll
    ) {
        record.setPoll(poll);
        record.setChestXray(laboratoryInstrumentalResearchMethodsDto.getChestXray());
        record.setChestXrayDeviations(laboratoryInstrumentalResearchMethodsDto.getChestXrayDeviations());
        record.setElectrocardiography(laboratoryInstrumentalResearchMethodsDto.getElectrocardiography());
        record.setElectrocardiographyDeviations(laboratoryInstrumentalResearchMethodsDto.getElectrocardiographyDeviations());
        record.setGeneralBloodAnalysis(laboratoryInstrumentalResearchMethodsDto.getGeneralBloodAnalysis());
        record.setHemoglobin(laboratoryInstrumentalResearchMethodsDto.getHemoglobin());
        record.setRedBloodCells(laboratoryInstrumentalResearchMethodsDto.getRedBloodCells());
        record.setLeukocytes(laboratoryInstrumentalResearchMethodsDto.getLeukocytes());
        record.setErythrocyteSedimentationRate(laboratoryInstrumentalResearchMethodsDto.getErythrocyteSedimentationRate());
        record.setGeneralUrineAnalysis(laboratoryInstrumentalResearchMethodsDto.getGeneralUrineAnalysis());
        record.setGeneralUrineAnalysisDeviations(laboratoryInstrumentalResearchMethodsDto.getGeneralUrineAnalysisDeviations());
        record.setBloodType(laboratoryInstrumentalResearchMethodsDto.getBloodType());
        record.setRhFactor(laboratoryInstrumentalResearchMethodsDto.getRhFactor());
        record.setBiochemicalStudies(laboratoryInstrumentalResearchMethodsDto.getBiochemicalStudies());
        record.setCholesterol(laboratoryInstrumentalResearchMethodsDto.getCholesterol());
        record.setTotalBilirubin(laboratoryInstrumentalResearchMethodsDto.getTotalBilirubin());
        record.setDirectBilirubin(laboratoryInstrumentalResearchMethodsDto.getDirectBilirubin());
        record.setIndirectBilirubin(laboratoryInstrumentalResearchMethodsDto.getIndirectBilirubin());
        record.setAlt(laboratoryInstrumentalResearchMethodsDto.getAlt());
        record.setAst(laboratoryInstrumentalResearchMethodsDto.getAst());
        record.setAlkalinePhosphatase(laboratoryInstrumentalResearchMethodsDto.getAlkalinePhosphatase());
        record.setGammaGlutamylTransferase(laboratoryInstrumentalResearchMethodsDto.getGammaGlutamylTransferase());
        record.setSerumGlucose(laboratoryInstrumentalResearchMethodsDto.getSerumGlucose());
        record.setFibrogastroduodenoscopy(laboratoryInstrumentalResearchMethodsDto.getFibrogastroduodenoscopy());
        record.setUltrasoundExaminationOfTheAbdominalOrgans(laboratoryInstrumentalResearchMethodsDto.getUltrasoundExaminationOfTheAbdominalOrgans());

        return laboratoryInstrumentalResearchMethodsRecordRepository.save(record);
    }

    public Poll createFullPoll(CreatePollDto createPollDto, Patient patient) {
        patient.setIsPollAvailable(false);
        Poll poll = create(new Poll(patient));

        saveGeneralInformation(createPollDto.getGeneralInformation(), new GeneralInformationRecord(), poll);
        saveAnamnesisOfLife(createPollDto.getAnamnesisOfLife(), new AnamnesisOfLifeRecord(), poll);
        saveCholecystectomy(createPollDto.getCholecystectomy(), new CholecystectomyRecord(), poll);
        saveClinicalPart(createPollDto.getClinicalPart(), new ClinicalPartRecord(), poll);
        saveLaboratoryInstrumentalResearchMethods(createPollDto.getLaboratoryInstrumentalResearchMethods(), new LaboratoryInstrumentalResearchMethodsRecord(), poll);

        return poll;
    }

    public List<Poll> getAllPatientPolls(Long patientId) {
        return pollRepository.findAllByPatientId(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Опросы пользователя не найдены."));
    }

    public GeneralInformationRecord getGeneralInformationRecord(Long pollId) {
        return generalInformationRecordRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("По указанному опросу не существует сохраненных"));
    }

    public AnamnesisOfLifeRecord getAnamnesisOfLifeRecord(Long pollId) {
        return anamnesisOfLifeRecordRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("По указанному опросу не существует сохраненных"));
    }

    public CholecystectomyRecord getCholecystectomyRecord(Long pollId) {
        return cholecystectomyRecordRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("По указанному опросу не существует сохраненных"));
    }

    public ClinicalPartRecord getClinicalPartRecord(Long pollId) {
        return clinicalPartRecordRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("По указанному опросу не существует сохраненных"));
    }

    public LaboratoryInstrumentalResearchMethodsRecord getLaboratoryInstrumentalResearchMethodsRecord(Long pollId) {
        return laboratoryInstrumentalResearchMethodsRecordRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("По указанному опросу не существует сохраненных"));
    }

    public PollDto getPoll(Long pollId) {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("Не удалось найти опрос"));
        String[] patientNameParts = poll.getPatient().getName().split(" ");
        return PollDto.builder()
                .id(pollId)
                .patientId(poll.getPatient().getId())
                .sex(poll.getPatient().getSex().getName())
                .firstName(patientNameParts[1])
                .surname(patientNameParts[0])
                .fatherName(patientNameParts[2])
                .generalInformation(getGeneralInformationRecord(pollId))
                .anamnesisOfLife(getAnamnesisOfLifeRecord(pollId))
                .laboratoryInstrumentalResearchMethods(getLaboratoryInstrumentalResearchMethodsRecord(pollId))
                .clinicalPart(getClinicalPartRecord(pollId))
                .cholecystectomy(getCholecystectomyRecord(pollId))
                .build();
    }

    public Poll updatePoll(CreatePollDto updatedPoll, Long id) {
        Poll poll = pollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Не удалось найти опрос"));
        GeneralInformationRecord generalInformationRecord = getGeneralInformationRecord(id);
        saveGeneralInformation(updatedPoll.getGeneralInformation(), generalInformationRecord, poll);

        AnamnesisOfLifeRecord anamnesisOfLifeRecord = getAnamnesisOfLifeRecord(id);
        saveAnamnesisOfLife(updatedPoll.getAnamnesisOfLife(), anamnesisOfLifeRecord, poll);

        CholecystectomyRecord cholecystectomyRecord = getCholecystectomyRecord(id);
        saveCholecystectomy(updatedPoll.getCholecystectomy(), cholecystectomyRecord, poll);

        LaboratoryInstrumentalResearchMethodsRecord laboratoryInstrumentalResearchMethodsRecord
                = getLaboratoryInstrumentalResearchMethodsRecord(id);
        saveLaboratoryInstrumentalResearchMethods(
                updatedPoll.getLaboratoryInstrumentalResearchMethods(),
                laboratoryInstrumentalResearchMethodsRecord,
                poll);

        ClinicalPartRecord clinicalPartRecord = getClinicalPartRecord(id);
        saveClinicalPart(updatedPoll.getClinicalPart(), clinicalPartRecord, poll);
        return poll;
    }

    public void deletePoll(Long id) {
        generalInformationRecordRepository.deleteById(id);
        clinicalPartRecordRepository.deleteById(id);
        cholecystectomyRecordRepository.deleteById(id);
        laboratoryInstrumentalResearchMethodsRecordRepository.deleteById(id);
        anamnesisOfLifeRecordRepository.deleteById(id);
        pollRepository.deleteById(id);
    }

    public String download(Long id) throws FileNotFoundException {
        return pollSerializerService.serializePoll(getPoll(id));
    }
}
