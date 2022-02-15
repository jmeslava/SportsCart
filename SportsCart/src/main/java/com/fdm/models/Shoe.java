package com.fdm.models;

import javax.persistence.Entity;

@Entity
public class Shoe extends Item {

	public Shoe() {
		super();
	}

	public Shoe(String img, String name, String desc, double price, Sport sport) {
		super(img, name, desc, price, sport);
	}

}
