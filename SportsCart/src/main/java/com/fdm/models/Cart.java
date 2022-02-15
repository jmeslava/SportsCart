package com.fdm.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(fetch = FetchType.EAGER)
	private List<CartItem> inCart;

	public Cart() {
		super();
		this.inCart = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CartItem> getInCart() {
		return inCart;
	}

	public void setInCart(List<CartItem> inCart) {
		this.inCart = inCart;
	}

	public void addItem(CartItem item, int amount) {
		boolean found = false;
		
		for (CartItem incart: this.inCart) {
			if (incart.getItem().getId() == item.getItem().getId()) {
				incart.setQuantityOrdered(incart.getQuantityOrdered() + amount);
				found = true;
			}
		}
		if (found == false) {
			this.inCart.add(item);
		}
		
	}

	public void removeItem(CartItem item, int amount) {
		CartItem toRemove = null;
		for (CartItem incart: this.inCart) {
			if (incart.getItem().getId() == item.getItem().getId()) {
				if ((incart.getQuantityOrdered() - amount) > 0) {
					incart.setQuantityOrdered(incart.getQuantityOrdered() - amount);
				}
				else if ((incart.getQuantityOrdered() - amount) <= 0) {
					incart.setQuantityOrdered(0);
					toRemove = incart;
				}
			}
		}
		if (toRemove != null) {
			this.inCart.remove(toRemove);
		}
	}
}
