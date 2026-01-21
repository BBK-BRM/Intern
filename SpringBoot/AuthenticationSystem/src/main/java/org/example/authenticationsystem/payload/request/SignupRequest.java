package org.example.authenticationsystem.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotBlank (message = "Username is required.")
    private String username;

    @Email (message = "Valid email is required.")
    @NotBlank (message = "Email is required.")
    private String email;

    @NotBlank(message = "password is required.")
    @Size(min = 8,message = "Must be at least 8.")
    private String password;

    @NotBlank(message = "role is required.")
    private String role;
}