package com.fdm.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fdm.models.Ball;
import com.fdm.models.Cart;
import com.fdm.models.CartItem;
import com.fdm.models.Item;
import com.fdm.models.Racquet;
import com.fdm.models.Shoe;
import com.fdm.models.Sport;

public class ModelsTest {

	private static final double DELTA = 0.001;
	private static final Sport BASKETBALL = Sport.BASKETBALL;
	private static final double PRICE = 1.99;
	private static final String NAME = "name";
	private static final String IMG = "img";
	private static final String DESC = "desc";
	private static final int ID = 1;

	@Test
	public void createwithDefaultConstructor() {
		Item item = new Ball();
		item.setId(ID);
		item.setDesc(DESC);
		item.setImg(IMG);
		item.setName(NAME);
		item.setPrice(PRICE);
		item.setSport(BASKETBALL);
		assertEquals(ID, item.getId());
		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(PRICE, item.getPrice(), DELTA);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createwithSpecialConstructor() {
		Item item = new Ball(IMG, NAME, DESC, PRICE, BASKETBALL);

		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(1.99, item.getPrice(), 0.001);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createRacquetwithDefaultConstructor() {
		Item item = new Racquet();
		item.setId(ID);
		item.setDesc(DESC);
		item.setImg(IMG);
		item.setName(NAME);
		item.setPrice(PRICE);
		item.setSport(BASKETBALL);
		assertEquals(ID, item.getId());
		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(PRICE, item.getPrice(), DELTA);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createRacquetwithSpecialConstructor() {
		Item item = new Racquet(IMG, NAME, DESC, PRICE, BASKETBALL);

		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(1.99, item.getPrice(), 0.001);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createShoewithDefaultConstructor() {
		Item item = new Shoe();
		item.setId(ID);
		item.setDesc(DESC);
		item.setImg(IMG);
		item.setName(NAME);
		item.setPrice(PRICE);
		item.setSport(BASKETBALL);
		assertEquals(ID, item.getId());
		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(PRICE, item.getPrice(), DELTA);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createShoewithSpecialConstructor() {
		Item item = new Shoe(IMG, NAME, DESC, PRICE, BASKETBALL);

		assertEquals(DESC, item.getDesc());
		assertEquals(IMG, item.getImg());
		assertEquals(NAME, item.getName());
		assertEquals(1.99, item.getPrice(), 0.001);
		assertEquals(BASKETBALL, item.getSport());

	}

	@Test
	public void createCartItemWithSpecialConstructor() {
		Item item = new Shoe(IMG, NAME, DESC, PRICE, BASKETBALL);

		CartItem cartItem = new CartItem(item, 10);
		cartItem.setShoppingCartItemId(ID);

		assertEquals(ID, cartItem.getShoppingCartItemId());
		assertEquals(item, cartItem.getItem());
		assertEquals(10, cartItem.getQuantityOrdered());

	}

	@Test
	public void createCartItemWithDefaultConstructor() {
		Item item = new Shoe(IMG, NAME, DESC, PRICE, BASKETBALL);

		CartItem cartItem = new CartItem();
		cartItem.setItem(item);
		cartItem.setQuantityOrdered(10);

		assertEquals(item, cartItem.getItem());
		assertEquals(10, cartItem.getQuantityOrdered());

	}

	@Test
	public void createCartWithDefaultConstructor() {
		List<CartItem> inCart = new ArrayList<>();
		inCart.add(new CartItem());
		Cart cart = new Cart();
		cart.setId(ID);
		cart.setInCart(inCart);

		assertEquals(ID, cart.getId());
		assertEquals(1, cart.getInCart().size());
	}
	
	@Test
	public void testAddItemToEmptyCart() {
		Cart cart = new Cart();
		CartItem cartItem = new CartItem();
		Item item = new Shoe();
		cartItem.setItem(item);
		
		cart.addItem(cartItem, 10);
		
		assertEquals(1, cart.getInCart().size());
	}
	
	@Test
	public void testAddItemToCart() {
		Cart cart = new Cart();
		CartItem cartItem = new CartItem();
		CartItem cartItem2 = new CartItem();
		CartItem cartItem3 = new CartItem();
		cartItem.setQuantityOrdered(10);
		cartItem2.setQuantityOrdered(10);
		cartItem3.setQuantityOrdered(10);
		
		Item item = new Shoe();
		item.setId(1);
		Item item2 = new Shoe();
		item.setId(1);
		Item item3 = new Ball();
		item.setId(2);
		
		
		cartItem.setItem(item);
		cartItem2.setItem(item2);
		cartItem3.setItem(item3);
		
		cart.addItem(cartItem, 10);
		cart.addItem(cartItem2, 1);
		cart.addItem(cartItem3, 1);
		System.out.println(cart.getInCart());
		assertEquals(2, cart.getInCart().size());
	}
	@Test
	public void testRemoveItemToCart() {
		Cart cart = new Cart();
		CartItem cartItem = new CartItem();
		CartItem cartItem2 = new CartItem();
		CartItem cartItem3 = new CartItem();
		cartItem.setQuantityOrdered(10);
		cartItem2.setQuantityOrdered(10);
		cartItem3.setQuantityOrdered(10);
		
		Item item = new Shoe();
		Item item2 = new Shoe();
		Item item3 = new Ball();
		
		List<CartItem> cartItems = new ArrayList<>();
		
		cartItem.setItem(item);
		cartItem2.setItem(item2);
		cartItem3.setItem(item3);
		
		cartItems.add(cartItem);
		cartItems.add(cartItem2);
		cartItems.add(cartItem3);
		
		cart.setInCart(cartItems);
		
		cart.removeItem(cartItem, 2);
		cart.removeItem(cartItem2, 11);
		
		assertEquals(2, cart.getInCart().size());
	}


}
