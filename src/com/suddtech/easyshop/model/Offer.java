package com.suddtech.easyshop.model;

import javax.validation.constraints.Size;

import com.suddtech.easyshop.validation.ValidEmail;

public class Offer {

	private int id;

	@Size(min = 5, max = 100, message = "Name most be between 5 and 100 characters")
	private String name;

	@ValidEmail(min=6, message="This email address is not valid.")
	private String email;

	@Size(min = 20, max = 255, message = "text most be between 20 and 255 characters")
	private String text;

	public Offer() {

	}

	public Offer(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", text=" + text + "]";
	}

}
