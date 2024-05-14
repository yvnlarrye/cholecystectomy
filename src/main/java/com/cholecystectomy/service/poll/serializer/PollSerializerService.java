package com.cholecystectomy.service.poll.serializer;

import com.cholecystectomy.domain.dto.poll.PollDto;

import java.io.FileNotFoundException;

public interface PollSerializerService {
    String  serializePoll(PollDto poll) throws FileNotFoundException;
}
