package com.example.banking.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectEmailPass.class)
     public ResponseEntity<String> handleIncorrectEmailPassException (IncorrectEmailPass incorrect){
        return new ResponseEntity<>(incorrect.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFound usernotfound){
        return new ResponseEntity<>(usernotfound.getMessage(),HttpStatus.NOT_FOUND);
    }

}
