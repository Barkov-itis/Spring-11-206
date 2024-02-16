package ru.itis.springdemo_11206.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springdemo_11206.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
