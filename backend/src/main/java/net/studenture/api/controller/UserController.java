package net.studenture.api.controller;

import net.studenture.api.controller.body.UserCreate;
import net.studenture.api.entities.User;
import net.studenture.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public User createUser(@RequestBody UserCreate userCreate) {
        User user = userService.createUser(userCreate);
        return user;
    }

}
