package com.csg.springdata.repositories;

import com.csg.springdata.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    public List<Item> findByNameLike(String name);
}
