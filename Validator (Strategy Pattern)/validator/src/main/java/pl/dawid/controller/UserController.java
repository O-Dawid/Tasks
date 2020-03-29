package pl.dawid.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.dawid.domain.User;
import pl.dawid.service.UserService;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}