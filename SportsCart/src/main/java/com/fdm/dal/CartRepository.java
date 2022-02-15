package com.fdm.dal;

import org.springframework.data.repository.CrudRepository;

import com.fdm.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

	Cart findCartById(int id);
}
