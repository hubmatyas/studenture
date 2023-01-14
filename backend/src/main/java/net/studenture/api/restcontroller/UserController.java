package net.studenture.api.restcontroller;

import net.studenture.api.restcontroller.body.UserCreate;
import net.studenture.api.entities.User;
import net.studenture.api.restcontroller.body.UserLogin;
import net.studenture.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
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

    @PostMapping("/login")
    public User loginUser(@RequestBody UserLogin userLogin) {
        User user;
        if (userLogin.getId() == null) {
            user = userService.loginUser(userLogin.getName(), userLogin.getPassword());
        } else {
            user = userService.loginUserGoogle(userLogin.getId());
        }
        return user;
    }

}
