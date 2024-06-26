package com.cholecystectomy.controller;

import com.cholecystectomy.domain.dto.job.CreateJobRequest;
import com.cholecystectomy.domain.dto.job.UpdateJobRequest;
import com.cholecystectomy.domain.model.Doctor;
import com.cholecystectomy.domain.model.Job;
import com.cholecystectomy.service.DoctorService;
import com.cholecystectomy.service.JobService;
import com.cholecystectomy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    private final UserService userService;
    private final DoctorService doctorService;

    @PostMapping("/job")
    public ResponseEntity<Job> createJob(@RequestBody CreateJobRequest request) {
        Job job = new Job(request.getName());
        return new ResponseEntity<>(jobService.create(job), new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody UpdateJobRequest request) {
        return new ResponseEntity<>(jobService.update(id, request), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        return new ResponseEntity<>(jobService.get(id), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getAllJobs() {
        Map<String, List<Job>> response = new HashMap<>();
        response.put("jobs", jobService.getAll());
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        doctorService.getDoctorsWithJob(id)
                        .forEach((doctor -> userService.deleteUser(doctor.getId())));
        jobService.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Должность удалена");
        return ResponseEntity.ok(response);
    }
}
