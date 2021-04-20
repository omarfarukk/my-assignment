package com.assignment.demo.payload.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private String timeStamp;
    private String message;
    private String description;
    private HttpStatus status;
}
