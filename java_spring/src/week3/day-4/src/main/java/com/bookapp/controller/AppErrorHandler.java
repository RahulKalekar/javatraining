package com.bookapp.controller;
//tbd
import com.bookapp.Dto.ErrorDto;
import com.bookapp.entities.ErrorDetails;
import com.bookapp.exceptions.BookNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppErrorHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.setTimestamp(System.currentTimeMillis());
        errorResponse.setMessages(errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFound(BookNotFoundException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorMessage(ex.getMessage())
                .timestamp(LocalTime.now())
                .errorCode(404)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle500(Exception ex){
        ErrorDetails errorDetails=  ErrorDetails.builder()
                .errorCode(500)
                .timestamp(LocalTime.now())
                .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
//BAsic exception handler
    //above is for validation
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
//
//        String errorMessage= ex.getBindingResult()
//                .getAllErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.joining(", "));
//
//        ErrorDetails errorDetails= ErrorDetails.builder()
//                .errorCode(400)
//                .timestamp(LocalTime.now())
//                .errorMessage(errorMessage).build();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
//    }
}