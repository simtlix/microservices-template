package com.simtlix.techgroups.template.business;

import com.simtlix.techgroups.template.model.Customer;

import java.util.List;

/**
 * Created by Facundo on 1/29/2018.
 */
public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}
