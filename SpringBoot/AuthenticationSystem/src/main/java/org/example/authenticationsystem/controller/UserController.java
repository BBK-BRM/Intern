package org.example.authenticationsystem.controller;

import jakarta.validation.Valid;
import org.example.authenticationsystem.payload.request.LoginRequest;
import org.example.authenticationsystem.payload.request.SignupRequest;
import org.example.authenticationsystem.payload.response.UserResponse;
import org.example.authenticationsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody SignupRequest request){
        UserResponse response = userService.registerUser(request);
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping ("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest request){
        UserResponse response = userService.loginUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }

    @GetMapping ("/")
    public String home(){
        return "Homepage";
    }
}