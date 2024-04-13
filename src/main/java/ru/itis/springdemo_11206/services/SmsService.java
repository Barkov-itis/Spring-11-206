package ru.itis.springdemo_11206.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
