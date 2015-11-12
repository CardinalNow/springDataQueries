package com.csg.springdata.repositories;

import com.csg.springdata.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
