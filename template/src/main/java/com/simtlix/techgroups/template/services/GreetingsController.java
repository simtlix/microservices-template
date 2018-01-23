package com.simtlix.techgroups.template.services;

import com.simtlix.techgroups.template.model.Greeting;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Greeting> listAll() {
        return Arrays.asList(new Greeting(1, "Hello Word!"), new Greeting(2, "Hola Mundo!"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Greeting> listById(@PathVariable Long id) {
        Greeting greetingFound;
        if (id == 1) {
            greetingFound = new Greeting(1, "Hello Word!");
        } else if (id == 2) {
            greetingFound = new Greeting(2, "Hola Mundo!");
        } else {
            greetingFound = null;
        }
        return new ResponseEntity(greetingFound, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Greeting> add(@RequestBody Greeting input) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.CREATED;
        try {
            if (input != null && input.getId() != 1 && input.getId() != 2) {
                httpHeaders.add("message", ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(input.getId()).toUri().toString());
            } else {
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                httpHeaders.add("message", String.format("Greeting id %s, already exists", input.getId()));
            }
        }catch(Exception ex){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpHeaders.add("message", String.format("Server Error: ", ex.getMessage()));
        }
        return new ResponseEntity(null, httpHeaders, httpStatus);
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Greeting updatedGreeting){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.OK;

        try{
            if (updatedGreeting != null ) {
                if (id != 1 && id != 2) {
                    httpStatus = HttpStatus.NOT_ACCEPTABLE;
                    httpHeaders.add("message", String.format("Greeting to modify does not exist.Id: %s", id));
                } else {
                        httpHeaders.add("message", ServletUriComponentsBuilder
                                .fromCurrentRequest().build().toUri().toString());
                }
            } else {
                httpStatus = HttpStatus.NOT_FOUND;
                httpHeaders.add("message", "Null greeting not acceptable");
            }
        }catch(Exception ex){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpHeaders.add("message", String.format("Server Error", ex.getMessage()));
        }
        return new ResponseEntity(null, httpHeaders, httpStatus);
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.OK;

        try{
            if (id != 1 && id != 2) {
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
                httpHeaders.add("message", String.format("Greeting to delete does not exist.Id: %s", id));
            } else {
                httpHeaders.add("message", String.format("Greeting deleted.Id: %s", id));
            }
        }catch(Exception ex){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpHeaders.add("message", String.format("Server Error", ex.getMessage()));
        }
        return new ResponseEntity(null, httpHeaders, httpStatus);
    }


}
