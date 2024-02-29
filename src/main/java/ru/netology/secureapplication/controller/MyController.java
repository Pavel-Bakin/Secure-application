package ru.netology.secureapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Это публичный endpoint, доступен без аутентификации!";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "Это закрытый endpoint, требует аутентификации!";
    }
}
