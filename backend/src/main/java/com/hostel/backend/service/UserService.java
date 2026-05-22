package com.hostel.backend.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.hostel.backend.dto.UserRequestDto;
import com.hostel.backend.dto.UserResponseDto;
import com.hostel.backend.entity.User;
import com.hostel.backend.repository.UserRepository;
import com.hostel.backend.exception.EmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.hostel.backend.security.JwtUtil;
import com.hostel.backend.dto.LoginRequestDto;
import com.hostel.backend.dto.LoginResponseDto;
import com.hostel.backend.exception.InvalidCredentialsException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil;    
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserRequestDto requestDto) {

        if (userRepository.existsByEmail(requestDto.getEmail())) {

    throw new EmailAlreadyExistsException(
            "Email already registered"
    );
}
        User user = new User();
        
        user.setFullName(requestDto.getFullName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(
        passwordEncoder.encode(requestDto.getPassword())
);
        user.setRole(requestDto.getRole());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    public LoginResponseDto loginUser(
        LoginRequestDto requestDto
) {

    Optional<User> optionalUser =
            userRepository.findByEmail(
                    requestDto.getEmail()
            );

    if (optionalUser.isEmpty()) {

        throw new InvalidCredentialsException(
                "Invalid email or password"
        );
    }

    User user = optionalUser.get();

    boolean isPasswordMatched =
            passwordEncoder.matches(
                    requestDto.getPassword(),
                    user.getPassword()
            );

    if (!isPasswordMatched) {

        throw new InvalidCredentialsException(
                "Invalid email or password"
        );
    }

    return new LoginResponseDto(
            jwtUtil.generateToken(user.getEmail()),
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getRole()
    );
}
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(user ->
                new UserResponseDto(
                        user.getId(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getRole()
                )
        ).collect(Collectors.toList());
    }
}