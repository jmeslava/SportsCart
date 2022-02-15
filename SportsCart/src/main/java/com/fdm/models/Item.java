package com.fdm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

	@Id
	@SequenceGenerator(name = "ITEM_SEQ_GNTR", sequenceName = "ITEM_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GNTR")
	private long id;
	protected String img;
	protected String name;
	protected String desc;
	protected double price;
	protected Sport sport;

	public Item() {
		super();
	}

	public Item(String img, String name, String desc, double price, Sport sport) {
		super();
		this.img = img;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.sport = sport;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}
