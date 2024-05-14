package com.cholecystectomy.service.poll.serializer.impl;

import com.cholecystectomy.domain.dto.poll.PollDto;
import com.cholecystectomy.domain.model.poll.*;
import com.cholecystectomy.service.PatientService;
import com.cholecystectomy.service.UserService;
import com.cholecystectomy.service.poll.serializer.PollSerializerService;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExcelPollSerializer implements PollSerializerService {

    @Value("${serializer.excel.template.filename}")
    private String templateFileName;
    @Value("${serializer.excel.output.filename}")
    private String outputFileName;

    @Autowired
    private UserService userService;

    private void clearTempDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    private String unifyFileName(String fileName) {
        String[] fileNameParts = fileName.split("\\.");
        String fileExtension = fileNameParts[fileNameParts.length - 1];
        String shortFileName = fileNameParts[0];
        return shortFileName + "_" + new Date().getTime() + "_" +
                userService.getCurrentUser().getId().toString() + "." + fileExtension;
    }

    private String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }

    private Map<String, Object> covertDtoToMap(PollDto poll) {
        Map<String, Object> data = new HashMap<>();

        GeneralInformationRecord generalInformation = poll.getGeneralInformation();
        AnamnesisOfLifeRecord anamnesisOfLife = poll.getAnamnesisOfLife();
        ClinicalPartRecord clinicalPart = poll.getClinicalPart();
        CholecystectomyRecord cholecystectomy = poll.getCholecystectomy();
        LaboratoryInstrumentalResearchMethodsRecord laboratory =
                poll.getLaboratoryInstrumentalResearchMethods();

        data.put("patientId", poll.getPatientId());
        data.put("surname", poll.getSurname());
        data.put("firstName", poll.getFirstName());
        data.put("fatherName", poll.getFatherName());
        data.put("sex", poll.getSex());

        data.put("createdAt", formatDate(generalInformation.getCreatedAt()));
        data.put("birthDate", formatDate(generalInformation.getBirthDate()));
        data.put("age", generalInformation.getAge());
        data.put("numberOfPregnancies", generalInformation.getNumberOfPregnancies());
        data.put("numberOfChildbirths", generalInformation.getNumberOfChildbirths());
        data.put("address", generalInformation.getAddress());
        data.put("phoneNumber", generalInformation.getPhoneNumber());
        data.put("height", generalInformation.getHeight());
        data.put("weight", generalInformation.getWeight());
        data.put("bodyMassIndex", generalInformation.getBodyMassIndex());
        data.put("deathDate", formatDate(generalInformation.getDeathDate()));

        data.put("concomitantDiseases", anamnesisOfLife.getConcomitantDiseases());
        data.put("smoking", anamnesisOfLife.getSmoking());
        data.put("alcoholAbuse", anamnesisOfLife.getAlcoholAbuse());
        data.put("allergy", anamnesisOfLife.getAllergy());

        data.put("cholelithiasisDiagnosisDate", formatDate(cholecystectomy.getCholelithiasisDiagnosisDate()));
        data.put("diseaseCourse", cholecystectomy.getDiseaseCourse());
        data.put("surgeryType", cholecystectomy.getSurgeryType());
        data.put("cholelithiasisOrder", cholecystectomy.getCholelithiasisOrder());
        data.put("emergencyReason", cholecystectomy.getEmergencyReason());
        data.put("complicationsChronicEndometritis", cholecystectomy.getComplicationsChronicEndometritis());
        data.put("koykoDays", cholecystectomy.getKoykoDays());
        data.put("descriptionOfMacropreparation", cholecystectomy.getDescriptionOfMacropreparation());
        data.put("heredityIsBurdenedWithCholelithiasis", cholecystectomy.getHeredityIsBurdenedWithCholelithiasis());

        data.put("chestXray", laboratory.getChestXray());
        data.put("chestXrayDeviations", laboratory.getChestXrayDeviations());
        data.put("electrocardiography", laboratory.getElectrocardiography());
        data.put("electrocardiographyDeviations", laboratory.getElectrocardiographyDeviations());
        data.put("generalBloodAnalysis", laboratory.getGeneralBloodAnalysis());
        data.put("hemoglobin", laboratory.getHemoglobin());
        data.put("redBloodCells", laboratory.getRedBloodCells());
        data.put("leukocytes", laboratory.getLeukocytes());
        data.put("erythrocyteSedimentationRate", laboratory.getErythrocyteSedimentationRate());
        data.put("generalUrineAnalysis", laboratory.getGeneralUrineAnalysis());
        data.put("generalUrineAnalysisDeviations", laboratory.getGeneralUrineAnalysisDeviations());
        data.put("bloodType", laboratory.getBloodType());
        data.put("rhFactor", laboratory.getRhFactor());
        data.put("biochemicalStudies", laboratory.getBiochemicalStudies());
        data.put("cholesterol", laboratory.getCholesterol());
        data.put("totalBilirubin", laboratory.getTotalBilirubin());
        data.put("directBilirubin", laboratory.getDirectBilirubin());
        data.put("indirectBilirubin", laboratory.getIndirectBilirubin());
        data.put("alt", laboratory.getAlt());
        data.put("ast", laboratory.getAst());
        data.put("alkalinePhosphatase", laboratory.getAlkalinePhosphatase());
        data.put("gammaGlutamylTransferase", laboratory.getGammaGlutamylTransferase());
        data.put("serumGlucose", laboratory.getSerumGlucose());
        data.put("fibrogastroduodenoscopy", laboratory.getFibrogastroduodenoscopy());
        data.put("ultrasoundExaminationOfTheAbdominalOrgans", laboratory.getUltrasoundExaminationOfTheAbdominalOrgans());

        data.put("pain", clinicalPart.getPain());
        data.put("localisation", clinicalPart.getLocalisation());
        data.put("irradiation", clinicalPart.getIrradiation());
        data.put("durance", clinicalPart.getDurance());
        data.put("attacksOfBiliaryColic", clinicalPart.getAttacksOfBiliaryColic());
        data.put("epigastricDiscomfort", clinicalPart.getEpigastricDiscomfort());
        data.put("impairedToleranceToFattyFoods", clinicalPart.getImpairedToleranceToFattyFoods());
        data.put("nausea", clinicalPart.getNausea());
        data.put("vomiting", clinicalPart.getVomiting());
        data.put("bitternessInTheMouth", clinicalPart.getBitternessInTheMouth());
        data.put("constipation", clinicalPart.getConstipation());
        data.put("diarrhea", clinicalPart.getDiarrhea());
        data.put("heartburn", clinicalPart.getHeartburn());
        data.put("sleepDisturbance", clinicalPart.getSleepDisturbance());
        data.put("fever", clinicalPart.getFever());

        return data;
    }

    @Override
    public String serializePoll(PollDto poll) throws FileNotFoundException {
        String tempDirectory = new File(outputFileName).getParent();
        clearTempDirectory(tempDirectory);

        String uniqueOutputFileName = unifyFileName(outputFileName);
        Map<String, Object> data = covertDtoToMap(poll);
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate(templateFileName)
                .build()
                .fill(data, new JxlsOutputFile(new File(uniqueOutputFileName)));
        return uniqueOutputFileName;
    }
}
