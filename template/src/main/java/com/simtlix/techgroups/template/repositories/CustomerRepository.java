package com.simtlix.techgroups.template.repositories;

import com.simtlix.techgroups.template.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Facundo on 1/29/2018.
 */

public interface CustomerRepository  extends PagingAndSortingRepository<Customer,Long> {
}
