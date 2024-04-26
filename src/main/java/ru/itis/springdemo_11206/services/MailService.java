package ru.itis.springdemo_11206.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
