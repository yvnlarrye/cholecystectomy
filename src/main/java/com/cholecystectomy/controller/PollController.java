package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.poll.CreatePollDto;
import com.cholecystectomy.domain.model.Patient;
import com.cholecystectomy.domain.model.poll.Poll;
import com.cholecystectomy.service.PatientService;
import com.cholecystectomy.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody CreatePollDto createPollDto) {
        Patient patient = patientService.getPatientById(createPollDto.getPatientId());
        return ResponseEntity.ok(pollService.createFullPoll(createPollDto, patient));
    }

}
