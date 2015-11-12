package com.csg.springdata.repositories;

import com.csg.springdata.SpringDataApplication;
import com.csg.springdata.model.Customer;
import com.csg.springdata.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rogerbowman on 11/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDataApplication.class)
public class RepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFind() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> collection = new ArrayList<>();
        customers.forEach(collection::add);
        assertEquals(12, collection.size());
    }

    @Test
    public void testFindCustomerByLastName() {
        List<Customer> customers = customerRepository.findByLastName("Simpson");
        assertNotNull(customers);
        assertEquals(5, customers.size());
    }

    @Test
    public void testFindCustomerByFirstNameOrLastName() {
        List<Customer> customers = customerRepository.findByLastNameOrFirstName("Bowman", "Homer");
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }

    @Test
    public void testFindCustomerByLastNameIgnoreCase() {
        List<Customer> customers = customerRepository.findByLastName("SIMPSON");
        assertEquals(0, customers.size());
        customers = customerRepository.findByLastNameIgnoreCase("SIMPSON");
        assertEquals(5, customers.size());
    }

    @Test
    public void testFindTop3ByLastName() {
        List<Customer> customers = customerRepository.findTop3ByLastName("Simpson");
        assertNotNull(customers);
        assertEquals(3, customers.size());
    }

    @Test
    public void testFindCustomersThatLiveIn() {
        List<Customer> customers = customerRepository.findCustomersThatLiveIn("Springfield");
        assertNotNull(customers);
        assertEquals(12, customers.size());

        customers = customerRepository.findCustomersThatLiveIn("12346");
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }

    @Test
    public void testFindOrdersForCustomerWithLastName() {
        List<Order> orders = orderRepository.findOrdersForCustomerWithName("Simpson");
        assertNotNull(orders);
        assertEquals(6, orders.size());
    }

}
