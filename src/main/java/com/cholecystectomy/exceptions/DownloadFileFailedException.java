package com.cholecystectomy.exceptions;

public class DownloadFileFailedException extends RuntimeException {
    public DownloadFileFailedException(String message) {
        super(message);
    }
}
