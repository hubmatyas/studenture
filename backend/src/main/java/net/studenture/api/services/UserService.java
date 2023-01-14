package net.studenture.api.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import net.studenture.api.restcontroller.body.UserCreate;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserRepository;
import net.studenture.api.utils.Session;
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

    public User loginUserGoogle(final long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return null;
        } else {
            User user = userOptional.get();
            user.setSessionId(Session.createSessionId());
            user.setSessionExpire(LocalDateTime.now());
            userRepository.save(user);
            user.setPassword(null);
            return user;
        }
    }

    public User loginUser(final String name, final String password) {
        Optional<User> userOptional = userRepository.findByName(name);
        if (!userOptional.isPresent()) {
            return null;
        } else {
            User user = userOptional.get();
            if (!Objects.equals(user.getPassword(), password)) {
                return null;
            } else {
                user.setSessionId(Session.createSessionId());
                user.setSessionExpire(LocalDateTime.now());
                userRepository.save(user);
                user.setPassword(null);
                return user;
            }
        }
    }
}