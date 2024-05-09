package com.cholecystectomy.service;

import com.cholecystectomy.domain.dto.job.UpdateJobRequest;
import com.cholecystectomy.domain.model.Job;
import com.cholecystectomy.exceptions.ResourceNotFoundException;
import com.cholecystectomy.repository.JobRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository repository;

    private Job save(Job job) {
        return repository.save(job);
    }

    public Job create(Job job) {
        if (repository.existsByName(job.getName())) {
            throw new EntityExistsException("Должность уже существует");
        }
        return save(job);
    }

    public Job get(Long jobId) {
        return repository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Должность не найдена"));
    }

    public Job update(Long id, UpdateJobRequest request) {
        if (repository.existsByName(request.getName())) {
            throw new EntityExistsException("Должность уже существует");
        }
        Job jobToUpdate = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Должность не найдена"));
        jobToUpdate.setName(request.getName());

        return save(jobToUpdate);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Должность не найдена");
        }
        repository.deleteById(id);
    }
}
