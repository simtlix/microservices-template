package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.Customer;
import com.simtlix.techgroups.template.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * Created by Facundo on 1/29/2018.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return  new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        ResponseEntity<Customer> responseEntity;
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer customerSaved = customerService.addCustomer(customer);
        return new ResponseEntity<>(customerSaved,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Long id) {
        ResponseEntity<Customer> responseEntity;
        Customer customerStored = customerService.getCustomer(id);
        if (customerStored == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            customer.setId(id);
            responseEntity = new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
