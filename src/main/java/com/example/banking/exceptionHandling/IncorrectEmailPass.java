package com.example.banking.exceptionHandling;

public class IncorrectEmailPass extends RuntimeException{
    private String message;

    public IncorrectEmailPass(String incorrectEmailOrPassword) {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void IncorrectEmailPass(String message) {
        this.message = message;
    }
}
