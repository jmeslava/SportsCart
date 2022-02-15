package com.fdm.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;

import com.fdm.dal.CartItemRepository;
import com.fdm.dal.CartRepository;
import com.fdm.dal.ItemRepository;
import com.fdm.models.Cart;
import com.fdm.models.CartItem;
import com.fdm.models.Item;
import com.fdm.models.Shoe;

public class ControllerTests {

	private static final String JSON_REQUEST = "{\"amount\":\"1\", \"id\":\"1\"}";

	private static itemController itemController;

	private static ItemRepository mockItemRepo;
	private static CartRepository mockCartRepo;
	private static CartItemRepository mockCartItemRepo;
	private static List<Item> mockItems;
	private static List<CartItem> mockCartItems;
	private static Cart mockCart;
	private static Item mockItem;
	private static CartItem mockCartItem;

	@Before
	public void init() {
		mockItemRepo = mock(ItemRepository.class);
		mockCartRepo = mock(CartRepository.class);
		mockCartItemRepo = mock(CartItemRepository.class);
		mockCart = mock(Cart.class);
		itemController = new itemController(mockItemRepo, mockCartRepo, mockCartItemRepo);
		mockItems = new ArrayList<>();
		mockItems.add(new Shoe());
		mockCartItems = new ArrayList<>();
		mockItem = mock(Item.class);
		mockCartItem = mock(CartItem.class);
	}

	@Test
	public void testGetItems() {
		when(itemController.getItems()).thenReturn(mockItems);
		when(mockItemRepo.findAll()).thenReturn(mockItems);
		List<Item> items = itemController.getItems();
		
		assertEquals(items.size(), mockItems.size());
		verify(mockItemRepo, times(1)).findAll();
	}
	
	@Test
	public void testGetCarrt() {
		when(mockCart.getInCart()).thenReturn(mockCartItems);
		when(mockCartRepo.findCartById(1)).thenReturn(mockCart);
		when(itemController.getCartItems()).thenReturn(mockCartItems);
		
		List<CartItem> items = itemController.getCartItems();
		
		verify(mockCartRepo, times(2)).findCartById(1);
		verify(mockCart, times(1)).getInCart();
	}
	
	@Test
	public void testAddItemToCartExisting() {
		when(mockItemRepo.findItemById(any())).thenReturn(mockItem);
		when(mockCartRepo.findCartById(1)).thenReturn(mockCart);
		when(mockCartItemRepo.findCartItemByItem(mockItem)).thenReturn(mockCartItem);
		
		itemController.addItemToCart(JSON_REQUEST);
		
		verify(mockCartItemRepo, times(1)).findCartItemByItem(mockItem);
		verify(mockCartRepo, times(1)).findCartById(1);
		verify(mockItemRepo, times(1)).findItemById(any());
	
	}
	@Test
	public void testAddItemToCartNull() {
		when(mockItemRepo.findItemById(any())).thenReturn(mockItem);
		when(mockCartRepo.findCartById(1)).thenReturn(mockCart);
		when(mockCartItemRepo.findCartItemByItem(mockItem)).thenReturn(null);
		
		itemController.addItemToCart(JSON_REQUEST);
		
		verify(mockCartItemRepo, times(1)).findCartItemByItem(mockItem);
		verify(mockCartRepo, times(1)).findCartById(1);
		verify(mockItemRepo, times(1)).findItemById(any());
	}
	
	@Test
	public void testReduceItem() {
		when(mockItemRepo.findItemById((long) 1)).thenReturn(mockItem);
		when(mockCartItemRepo.findCartItemByItem(mockItem)).thenReturn(mockCartItem);
		when(mockCartRepo.findCartById(1)).thenReturn(mockCart);
		
		itemController.reduceFromCart(JSON_REQUEST);
		
		verify(mockCartItemRepo, times(1)).findCartItemByItem(mockItem);
		verify(mockCartRepo, times(1)).findCartById(1);
		verify(mockItemRepo, times(1)).findItemById(any());
	}
	
	@Test
	public void testReduceItemNotLessThan0() {
		when(mockItemRepo.findItemById((long) 1)).thenReturn(mockItem);
		when(mockCartItemRepo.findCartItemByItem(mockItem)).thenReturn(mockCartItem);
		when(mockCartRepo.findCartById(1)).thenReturn(mockCart);
		when(mockCartItem.getQuantityOrdered()).thenReturn(5);
		
		itemController.reduceFromCart(JSON_REQUEST);
		
		verify(mockCartItemRepo, times(1)).findCartItemByItem(mockItem);
		verify(mockCartRepo, times(1)).findCartById(1);
		verify(mockItemRepo, times(1)).findItemById(any());
	}

}
