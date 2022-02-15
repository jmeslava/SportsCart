package com.fdm.models;

import javax.persistence.Entity;

@Entity
public class Racquet extends Item {

	public Racquet() {
		super();

	}

	public Racquet(String img, String name, String desc, double price, Sport sport) {
		super(img, name, desc, price, sport);
	
	}

}
