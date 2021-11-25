package com.loyalty.Reward.controller;

import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "query",required = false) String search) {

        List<User> users = userService.getUsers(search);
        return ResponseEntity.ok(users);

    }

}