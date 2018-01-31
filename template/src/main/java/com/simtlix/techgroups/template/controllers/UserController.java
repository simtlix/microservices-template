package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.User;
import com.simtlix.techgroups.template.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller which handles reqest for saving {@link User}s.
 *
 * @author Aliaksei Bahdanau
 */
@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName,
                       @RequestParam("email") String email) {

        User user = new User(firstName, lastName, email);
        userRepository.save(user);

        return "redirect:/";
    }
}