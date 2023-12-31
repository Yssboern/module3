package com.epam.learn.module3;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);

    UserResponseDto getUser(Long userId);

    List<UserResponseDto> getAllUsers();
}