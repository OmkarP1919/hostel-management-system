package com.hostel.backend.service;

import com.hostel.backend.dto.UserRequestDto;
import com.hostel.backend.dto.UserResponseDto;
import com.hostel.backend.entity.User;
import com.hostel.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {

        User user = new User();

        user.setFullName(requestDto.getFullName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setRole(requestDto.getRole());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getEmail(),
                savedUser.getRole()
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