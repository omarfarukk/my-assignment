package com.assignment.demo.advise;

import com.assignment.demo.controllers.MobileHandsetController;
import com.assignment.demo.payload.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice(basePackageClasses = MobileHandsetController.class)
public class ControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleAllExceptions(Throwable throwable){
        return ErrorResponse.builder()
                .timeStamp(LocalTime.now().toString())
                .message(throwable.getMessage())
                .description("Some Error Occurred during request processing")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
