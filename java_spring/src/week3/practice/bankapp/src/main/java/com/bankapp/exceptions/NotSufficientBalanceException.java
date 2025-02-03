package com.bankapp.exceptions;

public class NotSufficientBalanceException extends RuntimeException {
    public NotSufficientBalanceException(String message) {
        super(message);
    }
}
