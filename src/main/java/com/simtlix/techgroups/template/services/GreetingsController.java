package com.simtlix.techgroups.template.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String getGreetings() {
        return "Hello Word!";
    }
    
}
