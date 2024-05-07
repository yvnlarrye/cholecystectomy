package com.cholecystectomy.exceptions;

public class JobNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Должность не найдена";
    public JobNotFoundException() {
        super(MESSAGE);
    }
}
