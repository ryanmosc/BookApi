package com.bookApi.demo.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorMessage {
    private String message;
    private HttpStatus status;
    private int StatusCode;
    private LocalDateTime TimeStamp;
}
