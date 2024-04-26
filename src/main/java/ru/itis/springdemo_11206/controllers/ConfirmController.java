package ru.itis.springdemo_11206.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmController {
    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        // TODO: реализовать сервис для подтерждения (найти по коду человека и поставить ему статус CONFIRMED)
        // TODO: вернуть страницу об успешном прохождении подтверждения
        return null;
    }
}
