package pl.dawid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.dawid.domain.User;
import pl.dawid.service.UserService;

@RestController
public class RestUserController {

    UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}