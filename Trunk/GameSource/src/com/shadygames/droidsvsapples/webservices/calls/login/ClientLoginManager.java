package com.shadygames.droidsvsapples.webservices.calls.login;

import com.shadygames.droidsvsapples.webservices.backend.WebService;
import com.shadygames.droidsvsapples.webservices.backend.WebService.CallbackFunction;
import com.shadygames.droidsvsapples.webservices.backend.WebService.HTTPType;

public class ClientLoginManager {
	public static void AttemptLogin(LoginRequest request, CallbackFunction<LoginResponse> callback)
	{
		LoginCallback businessCallback = new ClientLoginManager(). new LoginCallback(callback);
		WebService.SendAsync(businessCallback, HTTPType.Post, "droids/api/login", request);
	}
	
	public class LoginCallback implements CallbackFunction<LoginResponse>
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
