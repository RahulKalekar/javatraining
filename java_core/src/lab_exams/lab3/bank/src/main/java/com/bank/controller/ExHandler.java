package com.bank.controller;

import com.bank.exception.AccountNotFoundException;
import com.bank.exception.InsufficientFundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleAccountNotFoundException(AccountNotFoundException ex) {
        ErrorDetail errorDetails = new ErrorDetail(
                ex.getMessage(),
                "The requested account could not be found",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(InsufficientFundException.class)
    public ResponseEntity<ErrorDetail> handleInsufficientFundsException(InsufficientFundException ex) {
        ErrorDetail errorDetails = new ErrorDetail(
                ex.getMessage(),
                "The account does not have enough balance for this operation",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetail> handleGenericException(RuntimeException ex) {
        ErrorDetail errorDetails = new ErrorDetail(
                ex.getMessage(),
                "An unexpected error occurred",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
}
