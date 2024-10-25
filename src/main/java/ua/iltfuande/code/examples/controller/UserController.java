package ua.iltfuande.code.examples.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.iltfuande.code.examples.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestParam String username) {
        return "User created: " + userService.createUser(username);
    }

    @PutMapping
    public String updateUser(@RequestParam String username) {
        return "User updated: " + userService.updateUser(username);
    }
}
