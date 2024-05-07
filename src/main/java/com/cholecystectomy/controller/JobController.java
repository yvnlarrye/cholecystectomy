package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.job.CreateJobRequest;
import com.cholecystectomy.domain.dto.job.UpdateJobRequest;
import com.cholecystectomy.domain.model.Job;
import com.cholecystectomy.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody CreateJobRequest request) {
        Job job = new Job(request.getName());
        return new ResponseEntity<>(jobService.create(job), new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody UpdateJobRequest request) {
        return new ResponseEntity<>(jobService.update(id, request), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        return new ResponseEntity<>(jobService.get(id), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        jobService.delete(id);
        return ResponseEntity.ok().build();
    }
}
