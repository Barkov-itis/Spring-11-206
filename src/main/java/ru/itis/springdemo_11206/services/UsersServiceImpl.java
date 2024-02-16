package ru.itis.springdemo_11206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.springdemo_11206.dto.UserDto;
import ru.itis.springdemo_11206.repository.UsersRepository;

import java.util.List;

import static ru.itis.springdemo_11206.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
}
