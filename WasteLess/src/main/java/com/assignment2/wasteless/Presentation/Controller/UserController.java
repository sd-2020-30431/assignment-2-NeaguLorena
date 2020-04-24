package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Bussiness.Service.UserService;
import com.assignment2.wasteless.Data.Repository.UserRepository;
import com.assignment2.wasteless.Presentation.Model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    @PostMapping("/validate-login")
    public User validateLogin(@RequestBody User user) {
        User logUser = userRepository.findByUsername(user.getUsername());
        if(user.getPassword().equals(logUser.getPassword()))
            userService.setLoggedUser(logUser);
        return logUser;
    }

}