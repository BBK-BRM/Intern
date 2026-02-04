package org.example.authenticationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.authenticationsystem.entity.User;
import org.example.authenticationsystem.exception.InvalidCredentialException;
import org.example.authenticationsystem.exception.UserAlreadyExitsException;
import org.example.authenticationsystem.payload.request.LoginRequest;
import org.example.authenticationsystem.payload.request.SignupRequest;
import org.example.authenticationsystem.payload.response.UserResponse;
import org.example.authenticationsystem.repository.UserRepository;
import org.example.authenticationsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserResponse registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExitsException("User already Exits.");
        }
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(
                request.getPassword()
        ));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public UserResponse loginUser(LoginRequest request) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialException("Invalid username or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialException("Invalid username or password.");
        }
        return modelMapper.map(user, UserResponse.class);
    }
}
