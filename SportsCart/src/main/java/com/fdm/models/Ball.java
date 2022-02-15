package com.fdm.models;

import javax.persistence.Entity;

@Entity
public class Ball extends Item {

	public Ball(String img, String name, String desc, double price, Sport sport) {
		super(img, name, desc, price, sport);
	}
	
	public Ball() {
		super();
	}

}
