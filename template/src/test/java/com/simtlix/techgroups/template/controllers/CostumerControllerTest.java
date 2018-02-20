package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.Customer;
import com.simtlix.techgroups.template.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Facundo on 2/20/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CostumerControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setEmail("test");
        customer.setName("test");
        customer.setLastName("test");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(customerRepository.findOne(any())).thenReturn(customer);

    }

    @Test
    public void testSaveOk() {
        Customer customer = new Customer();
        customer.setEmail("test");
        customer.setName("test");
        customer.setLastName("test");
        ResponseEntity<Customer> response = restTemplate.postForEntity(base.toString() + "api/customers", customer, Customer.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    public void testFindCustomer() {
        ResponseEntity<Customer> response = restTemplate.getForEntity(base.toString() + "api/customers/123123", Customer.class);
        assertEquals(123L, response.getBody().getId().longValue());
    }
}
