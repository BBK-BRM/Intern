package org.example.authenticationsystem.service.impl;

import org.example.authenticationsystem.entity.User;
import org.example.authenticationsystem.payload.request.LoginRequest;
import org.example.authenticationsystem.payload.request.SignupRequest;
import org.example.authenticationsystem.payload.response.UserResponse;
import org.example.authenticationsystem.repository.UserRepository;
import org.example.authenticationsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserResponse registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already Exits.");
        }
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(
                request.getPassword()
        ));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class) ;
    }

    @Override
    public UserResponse loginUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password.");
        }
        return modelMapper.map(user, UserResponse.class);
    }
}
