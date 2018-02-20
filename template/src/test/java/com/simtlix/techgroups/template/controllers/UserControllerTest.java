package com.simtlix.techgroups.template.controllers;

import com.simtlix.techgroups.template.model.User;
import com.simtlix.techgroups.template.repositories.UserRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserRepository userRepository;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");

        User user = new User();
        user.setId("123123");
        user.setEmail("test");
        user.setFirstName("test");
        user.setLastName("test");

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findOne(any())).thenReturn(user);

    }

    @Test
    public void testSaveOk() throws Exception {
        String expectedResponse = "{\"id\":1,\"email\":\"test\",\"firstName\":\"lastName\",\"email\":\"test\"}";
        User user = new User();
        user.setEmail("test");
        user.setFirstName("test");
        user.setLastName("test");
        ResponseEntity<User> response = restTemplate.postForEntity(base.toString() + "api/users/save", user, User.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }
    @Test
    public void testFindUser() throws Exception {
        ResponseEntity<User> response = restTemplate.getForEntity(base.toString() + "api/users/123123", User.class);
        assertEquals("123123", response.getBody().getId());

    }

}