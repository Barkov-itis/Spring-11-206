package ru.itis.springdemo_11206;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringDemo11206Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo11206Application.class, args);
    }

}