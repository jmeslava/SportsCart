package com.fdm.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fdm.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	List<Item> findAll();

	Item findItemById(Long Id);
	
}
