package com.microservices.tech.vt.user_services.user_services.controller;

import com.microservices.tech.vt.user_services.user_services.DTO.ResponseTemplate;
import com.microservices.tech.vt.user_services.user_services.entity.User;
import com.microservices.tech.vt.user_services.user_services.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("In saveUSer in controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.getUserWithDepartment(userId);
    }
}
