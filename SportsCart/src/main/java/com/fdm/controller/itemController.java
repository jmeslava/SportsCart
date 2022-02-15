package com.fdm.controller;

import java.util.List;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.dal.CartItemRepository;
import com.fdm.dal.CartRepository;
import com.fdm.dal.ItemRepository;
import com.fdm.models.Cart;
import com.fdm.models.CartItem;
import com.fdm.models.Item;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class itemController {

	private ItemRepository itemRepo;
	private CartRepository cartRepo;
	private CartItemRepository cartItemRepo;

	@Autowired
	public itemController(ItemRepository itemRepo, CartRepository cartRepo, CartItemRepository cartItemRepo) {
		super();
		this.itemRepo = itemRepo;
		this.cartRepo = cartRepo;
		this.cartItemRepo = cartItemRepo;

	}

	@GetMapping(value = "/items")
	public List<Item> getItems() {
		return itemRepo.findAll();
	}

	// add quantities
	@PostMapping(value = "/items")
	public void addItemToCart(@RequestBody String data) {

		JSONObject req = new JSONObject(data);

		long uid = req.getLong("id");
		int amount = req.getInt("amount");

		Item item = itemRepo.findItemById(uid);
		Cart cart = cartRepo.findCartById(1);
		CartItem exists = cartItemRepo.findCartItemByItem(item);
		if (exists == null) {
			CartItem newItem = new CartItem(item, amount);
			cartItemRepo.save(newItem);
			cart.addItem(newItem, amount);
			cartRepo.save(cart);

		} else {

			cart.addItem(exists, amount);
			cartItemRepo.save(exists);
			cartRepo.save(cart);
		}
	}

	@GetMapping(value = "/myCart")
	public List<CartItem> getCartItems() {

		Cart cart = cartRepo.findCartById(1);
		return cart.getInCart();
	}

	@PutMapping(value = "/myCart")
	public void reduceFromCart(@RequestBody String data) {
		JSONObject req = new JSONObject(data);
		long uid = req.getLong("id");
		int amount = req.getInt("amount");
		Item item = itemRepo.findItemById(uid);

		CartItem cartItem = cartItemRepo.findCartItemByItem(item);
		Cart cart = cartRepo.findCartById(1);
		cart.removeItem(cartItem, amount);
		if (cartItem.getQuantityOrdered() < 1) {
			cartItemRepo.delete(cartItem);
		} else {
			cartItemRepo.save(cartItem);
		}
		cartRepo.save(cart);
	}
}
