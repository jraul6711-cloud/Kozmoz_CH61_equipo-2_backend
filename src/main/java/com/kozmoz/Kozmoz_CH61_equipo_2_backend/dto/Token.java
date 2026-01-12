package com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto;

public class Token {
private String accessToken;
	
	public Token(String accessToken) {
		super();
		this.accessToken = accessToken;
	}//Constructor
	
	public String getAccessToken() {
		return accessToken;
	}//getAccessToken
	
}//class Token
