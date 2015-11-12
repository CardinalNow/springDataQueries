package com.csg.springdata.repositories;

import com.csg.springdata.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByLastNameOrFirstName(String lastName, String firstName);

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findTop3ByLastName(String lastName);

    @Query("Select c from Customer c where c.city = ?1 or c.state = ?1 or c.zipCode = ?1 or c.country = ?1")
    List<Customer> findCustomersThatLiveIn(String search);
}
