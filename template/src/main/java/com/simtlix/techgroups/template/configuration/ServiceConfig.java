package com.simtlix.techgroups.template.configuration;

import com.simtlix.techgroups.template.business.CustomerService;
import com.simtlix.techgroups.template.business.CustomerServiceImpl;
import com.simtlix.techgroups.template.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Facundo on 1/29/2018.
 */
@Configuration
public class ServiceConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public CustomerService customerService(){return new CustomerServiceImpl(customerRepository);}

}
