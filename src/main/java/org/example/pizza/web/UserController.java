package org.example.pizza.web;

import org.example.pizza.model.User;
import org.example.pizza.service.AuthenticatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthenticatorService authService;

    @Autowired
    public UserController(AuthenticatorService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/register")
    public UserDto register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = authService.register(username, email, password);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        User user = authService.getUserByUsername(username);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
