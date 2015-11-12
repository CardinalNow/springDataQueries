package com.csg.springdata.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Entity
@Table(name = "customer_order")
public class Order extends AbstractPersistable<Integer> {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item product;

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
