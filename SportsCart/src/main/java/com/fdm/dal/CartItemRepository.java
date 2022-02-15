package com.fdm.dal;

import org.springframework.data.repository.CrudRepository;

import com.fdm.models.CartItem;
import com.fdm.models.Item;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{

	CartItem findCartItemByItem(Item item);
}
