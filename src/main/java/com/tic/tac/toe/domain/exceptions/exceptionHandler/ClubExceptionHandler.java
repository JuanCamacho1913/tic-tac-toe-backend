package com.tic.tac.toe.domain.exceptions.exceptionHandler;

import com.tic.tac.toe.domain.exceptions.ClubNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ClubExceptionHandler {

    @ExceptionHandler(ClubNotFoundException.class)
    public ResponseEntity<String> handlerError(ClubNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> errorValidation(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach((error) -> {
                    String name = error.getField();
                    String message = error.getDefaultMessage();
                    errors.put(name, message);
                });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
