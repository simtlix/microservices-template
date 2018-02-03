package com.simtlix.techgroups.template.repositories;

import com.simtlix.techgroups.template.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository for saving new and retrieving existing {@link User}s from MongoDB
 *
 * @author Aliaksei Bahdanau
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}