package com.hms.exceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDto {

    private String message;
    private LocalDateTime timestamp;
    private String details;

    public ErrorDto(String message, LocalDateTime timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
