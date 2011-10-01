package com.shadygames.droidsvsapples.webservices.calls.login;

import com.shadygames.droidsvsapples.webservices.backend.WebService;
import com.shadygames.droidsvsapples.webservices.backend.WebService.CallbackFunction;
import com.shadygames.droidsvsapples.webservices.backend.WebService.HTTPType;

public class ClientLoginManager {
	
	/**
	 * Publicly accessible function for logging in
	 * @param username
	 * @param password
	 * @param callback
	 */
	public static void AttemptLogin(String username, String password, CallbackFunction<LoginResponse> callback)
	{
		AttemptLogin(new LoginRequest(username, password), callback);
	}
	
	/**
	 * Private login method
	 * @param request
	 * @param callback
	 */
	private static void AttemptLogin(LoginRequest request, CallbackFunction<LoginResponse> callback)
	{
		LoginCallback businessCallback = new ClientLoginManager(). new LoginCallback(callback);
		WebService.SendAsync(businessCallback, HTTPType.Post, "api/testlogin", request, LoginResponse.class);
	}
	
	/**
	 * The class that handles callbacks for login response.
	 * @author Travis
	 *
	 */
	private class LoginCallback implements CallbackFunction<LoginResponse>
	{
		CallbackFunction<LoginResponse> callback;
		
		public LoginCallback(CallbackFunction<LoginResponse> _callback)
		{
			callback = _callback;
		}
		
		@Override
		public void function(Exception ex, LoginResponse result) {
			// TODO Auto-generated method stub
			callback.function(ex,result);
		}
		
	}
}
