package com.suddtech.easyshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.suddtech.easyshop.dao.util.Util;
@Entity
public class Product implements Comparable<Product>, Serializable {
private int id;
private String name;
private String description;
private String color;
private int weight;
private String productmodel;
private int priceInCents;
private String imgUrl;
private double price;

@Column(name="thumbnail_photo")
private byte[] pic;

public Product(Long id2, String desc, int priceInCents2, String imgUrl) {
	// TODO Auto-generated constructor stub
}

public Product(int id, String description, int priceInCents, String imgUrl,
		double price) {
	super();
	this.id = id;
	this.description = description;
	this.priceInCents = priceInCents;
	this.imgUrl = imgUrl;
	this.price = price;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

public String getProductmodel() {
	return productmodel;
}

public void setProductmodel(String productmodel) {
	this.productmodel = productmodel;
}

public byte[] getPic() {
	return pic;
}

public void setPic(byte[] pic) {
	this.pic = pic;
}
public String getPriceInDollars() {
	return Util.getPriceInDollars(priceInCents);
}
public int getPriceInCents() {
	return priceInCents;
}

public void setPriceInCents(int priceInCents) {
	this.priceInCents = priceInCents;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int compareTo(Product p) {
	int c = description.compareTo(p.description);
	return (c == 0 ? ((Integer) id).compareTo((Integer) p.id) : c);
}

}
