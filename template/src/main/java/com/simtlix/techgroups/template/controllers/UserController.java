package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.User;
import com.simtlix.techgroups.template.repositories.UserRepository;
import com.simtlix.techgroups.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller which handles reqest for saving {@link User}s.
 *
 * @author Aliaksei Bahdanau
 */
@Controller
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user) {
        User userSaved =  userService.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/JSON")
    public User findById(@PathVariable("id") String userID) {
        return userService.findOne(userID);
    }
}