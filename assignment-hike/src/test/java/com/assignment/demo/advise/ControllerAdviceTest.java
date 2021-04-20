package com.assignment.demo.advise;

import com.assignment.demo.payload.error.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControllerAdviceTest {
    private ControllerAdvice controllerAdvice = new ControllerAdvice();
    @Test
    void handleAllExceptions_runtime() {
        Throwable throwable = new RuntimeException("Test Runtime Exception");
        ErrorResponse expectedResponse = ErrorResponse.builder()
                .timeStamp(LocalTime.now().toString())
                .message(throwable.getMessage())
                .description("Some Error Occurred during request processing")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        ErrorResponse actualResponse =controllerAdvice.handleAllExceptions(throwable);
        assertTrue(expectedResponse.getMessage().contentEquals(actualResponse.getMessage()));
    }

    @Test
    void handleAllExceptions_checked_Exception() {
        Throwable throwable = new IOException("Test IO Exception");
        ErrorResponse expectedResponse = ErrorResponse.builder()
                .timeStamp(LocalTime.now().toString())
                .message(throwable.getMessage())
                .description("Some Error Occurred during request processing")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        ErrorResponse actualResponse =controllerAdvice.handleAllExceptions(throwable);
        assertTrue(expectedResponse.getMessage().contentEquals(actualResponse.getMessage()));
    }

    @Test
    void handleAllExceptions_error() {
        Throwable throwable = new Error("Test IO Exception");
        ErrorResponse expectedResponse = ErrorResponse.builder()
                .timeStamp(LocalTime.now().toString())
                .message(throwable.getMessage())
                .description("Some Error Occurred during request processing")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        ErrorResponse actualResponse =controllerAdvice.handleAllExceptions(throwable);
        assertTrue(expectedResponse.getMessage().contentEquals(actualResponse.getMessage()));
    }
}