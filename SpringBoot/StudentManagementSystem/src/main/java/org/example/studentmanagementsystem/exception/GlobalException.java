package org.example.studentmanagementsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;
    private final String debugMessage;

    public GlobalException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.UNPROCESSABLE_CONTENT;
        this.debugMessage = "";
    }

    public GlobalException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.debugMessage = "";
    }
}
