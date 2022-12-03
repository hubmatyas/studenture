package net.studenture.api.services;

import java.util.List;
import java.util.Optional;

import net.studenture.api.controller.body.UserCreate;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This service is for manipulating with UserRepository
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByNamePassword(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    public User createUser(final UserCreate userCreate) {
        User user = new User(userCreate.getName(), userCreate.getEmail(), userCreate.getPassword());
        userRepository.save(user);
        return user;
    }
}