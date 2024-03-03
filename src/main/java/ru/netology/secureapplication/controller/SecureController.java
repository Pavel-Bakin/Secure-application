package ru.netology.secureapplication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecureController {

    @GetMapping("/secured/read")
    @Secured("ROLE_READ")
    public String securedRead() {
        return "Этот метод доступен только для пользователей с ролью READ";
    }

    @GetMapping("/secured/write")
    @RolesAllowed("ROLE_WRITE")
    public String securedWrite() {
        return "Этот метод доступен только для пользователей с ролью WRITE";
    }

    @GetMapping("/secured/write-or-delete")
    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public String securedWriteOrDelete() {
        return "Этот метод доступен только для пользователей с ролью WRITE или DELETE";
    }

    @GetMapping("/secured/check-username")
    public String checkUsername(Authentication authentication, @RequestParam String username) {
        String authenticatedUsername = authentication.getName();
        if (authenticatedUsername.equals(username)) {
            return "Имя пользователя совпадает с текущим пользователем";
        } else {
            return "Имя пользователя не совпадает с текущим пользователем";
        }
    }
}