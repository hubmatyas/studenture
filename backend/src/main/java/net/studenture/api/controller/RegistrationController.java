package net.studenture.api.controller;

import net.studenture.api.entities.Role;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
     public String addUser(User user, Map<String,Object> model){
        User userFromDB = userRepository.findByName(user.getName());
       if(userFromDB != null){
          model.put("message","UserExists");
         return "registration";
       }

    //   user.setRoles(Collections.singleton(Role.USER));
        return "redirect:/login";

     }
}
