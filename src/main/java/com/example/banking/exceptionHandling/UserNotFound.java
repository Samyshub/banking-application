package com.example.banking.exceptionHandling;

public class UserNotFound extends RuntimeException{
    private String message;

    public UserNotFound(String s) {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void UserNotFound(String message) {
        this.message = message;
    }
}
