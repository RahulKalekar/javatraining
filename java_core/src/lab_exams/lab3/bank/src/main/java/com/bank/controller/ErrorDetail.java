package com.bank.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;import lombok.NoArgsConstructor;
import lombok.Setter;import java.time.LocalDateTime;
@Getter@Setter@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private String message;
    private String details;
    private LocalDateTime timestamp;
}