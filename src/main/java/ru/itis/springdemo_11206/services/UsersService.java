package ru.itis.springdemo_11206.services;

import ru.itis.springdemo_11206.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}
