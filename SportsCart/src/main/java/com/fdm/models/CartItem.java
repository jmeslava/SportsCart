package com.fdm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Shopping_CartItemLink")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shoppingCartItemId;
	@OneToOne
	private Item item;
	private int quantityOrdered;
	
	public CartItem( Item item, int quantityOrdered) {
		super();
		this.item = item;
		this.quantityOrdered = quantityOrdered;
	}
	
	public CartItem() {
		super();
	}
	public int getShoppingCartItemId() {
		return shoppingCartItemId;
	}
	public void setShoppingCartItemId(int shoppingCartItemId) {
		this.shoppingCartItemId = shoppingCartItemId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	
	
}
