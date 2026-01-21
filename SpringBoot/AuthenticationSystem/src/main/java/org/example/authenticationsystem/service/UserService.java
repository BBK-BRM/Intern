package org.example.authenticationsystem.service;

import org.example.authenticationsystem.payload.request.LoginRequest;
import org.example.authenticationsystem.payload.request.SignupRequest;
import org.example.authenticationsystem.payload.response.UserResponse;

public interface UserService {
    UserResponse registerUser(SignupRequest request);
    UserResponse loginUser(LoginRequest request);
}
