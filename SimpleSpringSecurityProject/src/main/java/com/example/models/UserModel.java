package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userDB")      //to connect to mongo database
public class UserModel {
	
	@Id
	private String id;
	private String username;
	private String password;
	public String getId() {
		return id;
	}
	
	public UserModel() {
		
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
	
	

}
