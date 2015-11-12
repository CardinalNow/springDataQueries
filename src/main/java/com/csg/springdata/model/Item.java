package com.csg.springdata.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Entity
public class Item extends AbstractPersistable<Integer> {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
