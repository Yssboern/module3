package com.epam.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setBirthday(LocalDate.parse(userRequestDto.getBirthday()));

        User savedUser = userRepository.save(user);
        return mapUserToResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Update fields from the request, but only if they are not null
            if (userRequestDto.getName() != null) {
                user.setName(userRequestDto.getName());
            }
            if (userRequestDto.getSurname() != null) {
                user.setSurname(userRequestDto.getSurname());
            }
            if (userRequestDto.getBirthday() != null) {
                user.setBirthday(LocalDate.parse(userRequestDto.getBirthday()));
            }
            User updatedUser = userRepository.save(user);
            return mapUserToResponseDto(updatedUser);
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return mapUserToResponseDto(user);
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapUserToResponseDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto mapUserToResponseDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setSurname(user.getSurname());
        responseDto.setBirthday(String.valueOf(user.getBirthday()));
        return responseDto;
    }
}
