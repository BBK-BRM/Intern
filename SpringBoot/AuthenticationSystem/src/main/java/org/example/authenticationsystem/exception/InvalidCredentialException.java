package org.example.authenticationsystem.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidCredentialException extends RuntimeException {
    private String message;
}
