package com.shadygames.droidsvsapples.webservices.calls.login;

public class LoginRequest {
	public String username;
	public String password;
	
	public LoginRequest ( String _username, String _password ) {
		username = _username;
		password = _password;
	}
}
