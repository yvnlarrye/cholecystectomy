package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.poll.CreatePollDto;
import com.cholecystectomy.domain.dto.poll.PollDto;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.poll.Poll;
import com.cholecystectomy.service.PatientService;
import com.cholecystectomy.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPoll(@RequestBody CreatePollDto createPollDto) {
        Patient patient = patientService.getPatientById(createPollDto.getPatientId());
        if (patient.getIsPollAvailable()) {
            return ResponseEntity.ok(pollService.createFullPoll(createPollDto, patient));
        }
        Map<String, String> response = new HashMap<>();
        response.put("error", "Пациенту не назначен опрос");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollDto> getPoll(@PathVariable Long id) {
        return ResponseEntity.ok(pollService.getPoll(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable Long id, @RequestBody CreatePollDto updatedPoll) {
        return ResponseEntity.ok(pollService.updatePoll(updatedPoll, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePoll(@PathVariable Long id) {
        pollService.deletePoll(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Poll has been deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadPoll(@PathVariable Long id) throws FileNotFoundException {
        String pollFileName = pollService.download(id);
        Path filePath = Paths.get(pollFileName);
        Resource fileResource = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filePath.getFileName().toString() + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(filePath.toFile().length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileResource);
    }

}

