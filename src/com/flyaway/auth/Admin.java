package com.flyaway.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {

	@Id
	@GeneratedValue
	private int userId;
	
	private String userName;
	private String password;
	
	
	
	
	
	
	public Admin() {
		super();
	}




	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	
	
	
	
	
	
}
