package com.csg.springdata.repositories;

import com.csg.springdata.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("Select o from Order o where o.customer.firstName = :name or o.customer.lastName = :name")
    List<Order> findOrdersForCustomerWithName(@Param("name") String name);
}
