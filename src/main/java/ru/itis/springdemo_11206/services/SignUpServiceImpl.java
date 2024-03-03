package ru.itis.springdemo_11206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_11206.dto.UserForm;
import ru.itis.springdemo_11206.models.Role;
import ru.itis.springdemo_11206.models.User;
import ru.itis.springdemo_11206.repository.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstname())
                .lastName(userForm.getLastname())
                .confirmed("CONFIRMED")
                .role(Role.ADMIN)
                .build();
        usersRepository.save(user);
    }
}
