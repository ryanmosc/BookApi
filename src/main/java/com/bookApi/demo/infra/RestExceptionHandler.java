package com.bookApi.demo.infra;

import com.bookApi.demo.Exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    private ResponseEntity<RestErrorMessage> bookNotFoundHandler(BookNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
}
