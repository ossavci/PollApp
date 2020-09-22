package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.util.EnumerationUtil.UserType;



/**
 * @author Savci
 *
 */
@Entity
@Table(name = "PollUser")
public class PollUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "username",unique = true)
	private String username;
	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.ORDINAL)
	private UserType userType;

	public PollUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PollUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public PollUser(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	

	public PollUser(String username, String password, UserType userType) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
