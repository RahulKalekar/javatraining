package com.bankapp.controller;

import com.bankapp.entity.ErrorDetails;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.exceptions.NotSufficientBalanceException;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){

        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorDetails errorDetails= ErrorDetails.builder()
                .errorCode(400)
                .timestamp(LocalTime.now())
                .errorMessage(errorMessage).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleException(AccountNotFoundException ex){

        ErrorDetails errorDetails= ErrorDetails.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalTime.now())
                .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
    @ExceptionHandler(NotSufficientBalanceException.class)
    public ResponseEntity<ErrorDetails> handleNotSufficientBalanceException(NotSufficientBalanceException ex){

        ErrorDetails errorDetails= ErrorDetails.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalTime.now())
                .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
