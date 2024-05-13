package com.cholecystectomy.repository.poll;

import com.cholecystectomy.domain.model.poll.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    Optional<List<Poll>> findAllByPatientId(Long id);
}
