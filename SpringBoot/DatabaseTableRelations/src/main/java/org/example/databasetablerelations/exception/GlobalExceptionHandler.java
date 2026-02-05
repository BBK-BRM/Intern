package org.example.databasetablerelations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<String> handleGlobalException(GlobalException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Request method : "+e.getMethod()+
                "\nSupported Method : "+ e.getSupportedMethods());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
