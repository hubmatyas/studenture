package net.studenture.api.restcontroller;

import java.util.Map;
import java.util.Optional;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserRepository;
import net.studenture.api.restcontroller.body.UserCreate;
import net.studenture.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("")
     public Map<String,Object> addUser(User user, Map<String,Object> model){
       Optional<User> userByName = userRepository.findByName(user.getName());
       Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());
       if(!userByName.isPresent()) {
           model.put("message", "User with name " + user.getName() + " already exists.");
           model.put("result", false);
       } else if (!userByEmail.isPresent()) {
           model.put("message", "User with email " + user.getEmail() + " already exists.");
           model.put("result", false);
       } else {
           UserService userService = new UserService(userRepository);
           UserCreate userCreate = new UserCreate();
           userCreate.setName((String) model.get("name"));
           userCreate.setEmail((String) model.get("email"));
           userCreate.setPassword((String) model.get("password"));
           userService.createUser(userCreate);
           model.put("message", "User with name " + user.getName() + " and email " + user.getEmail() + " created.");
           model.put("result", true);
       }
        return model;
     }
}
