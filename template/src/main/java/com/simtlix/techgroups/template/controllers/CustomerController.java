package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.Customer;
import com.simtlix.techgroups.template.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Facundo on 1/29/2018.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/JSON")
    public ResponseEntity<List<Customer>> getCustomers() {
        ResponseEntity<List<Customer>> responseEntity;
        List<Customer> customers = customerService.getCustomers();
        if (customers == null || customers.isEmpty()) {
           responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            responseEntity = new ResponseEntity<>(customers,HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}", produces = "application/JSON")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        ResponseEntity<Customer> responseEntity;
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/JSON")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        ResponseEntity<Customer> responseEntity;
        Customer customerStored = customerService.addCustomer(customer);
        if (customerStored == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            responseEntity = new ResponseEntity<>(customerStored,HttpStatus.CREATED);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.PUT,produces = "application/JSON")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        ResponseEntity<Customer> responseEntity;
        Customer customerStored = customerService.updateCustomer(customer);
        if (customerStored == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            responseEntity = new ResponseEntity<>(customerStored,HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }






}
