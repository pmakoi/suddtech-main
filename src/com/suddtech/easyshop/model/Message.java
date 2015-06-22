package com.suddtech.easyshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.suddtech.easyshop.validation.ValidEmail;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@ValidEmail
	private String email;
	@Size(min = 4, max = 15)
	private String name;

	@Size(min = 8, max = 100)
	private String subject;

	@Size(min = 8, max = 5000)
	private String content;
	@NotBlank
	@Size(min = 4, max = 60)
	// @Column(nullable=false)
	//@Column(updatable=false, insertable=false)
	 private String username;
//	@ManyToOne
//	@JoinColumn(name = "username")
//	private User user;

	public Message() {
		//this.user = user;
	}

	public Message(String email, String subject, String content,
			String name/* , String username */) {
		this.email = email;
		this.subject = subject;
		//this.user = user;
		this.content = content;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//	public String getUsername(){
//		return user.getUsername();
//	//	return this.getUser().setUsername(username);
//	}
//	public void setUsername(String username){
//		this.getUser().setUsername(username);
//		//user.setUsername(username);
//	}
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
