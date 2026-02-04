package org.example.authenticationsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (value = UserAlreadyExitsException.class)
    @ResponseBody
    public ErrorResponse handleUserAlreadyExitsException(UserAlreadyExitsException ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler (value = InvalidCredentialException.class)
    @ResponseBody
    public ErrorResponse handleUserAlreadyExitsException(InvalidCredentialException ex){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
