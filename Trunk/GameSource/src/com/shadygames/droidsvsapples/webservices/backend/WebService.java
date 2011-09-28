package com.shadygames.droidsvsapples.webservices.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;


public class WebService {
	private static Gson gson = new Gson();
	private static final String WEB_URL = "http://hostname:80/";
	
	public enum HTTPType {
		Get, Post
	}
	
	public interface CallbackFunction<T> {
		void function(Exception ex, T result);
	}
	
	private static class ThreadedClass<T> implements Runnable {
		CallbackFunction<T> callback;
		HTTPType type;
		String request;
		Object obj;
		
		public ThreadedClass(CallbackFunction<T> _callback, HTTPType _type, String _request, Object _obj)
		{
			callback = _callback;
			type = _type;
			request = _request;
			obj = _obj;
		}
		
		public void run() {
			SendRequest(callback, type, request, obj);
		}
	}
	
	public static <T> void SendAsync(CallbackFunction<T> callback, HTTPType type, String request, Object obj)
	{
		new Thread(
				new ThreadedClass<T>(callback, type, request, obj)
		).start();
		
	}
	
	public static <T> void SendSync(CallbackFunction<T> callback, HTTPType type, String request, Object obj)
	{
		SendRequest(callback, type, request, obj);
	}
	
	private static <T> void SendRequest(CallbackFunction<T> callback, HTTPType type, String request, Object obj)
	{
		try {
		    String data = null;      
		    OutputStreamWriter wr = null;
		    
		    if ( type == HTTPType.Post )
		    {
		    	data = gson.toJson(obj);
		    }
		    
		    // Send data
		    URL url = new URL(WEB_URL + request);
		    URLConnection conn = url.openConnection();
		    if ( type == HTTPType.Post )
		    {     
		    	conn.setDoOutput(true);
		    	wr = new OutputStreamWriter(conn.getOutputStream());
		    	wr.write(data);
		    	wr.flush();
		    }

		    // Get the response
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line;
		    String json = "";
		    while ((line = rd.readLine()) != null) {
		        // Process line...
		    	json += line;
		    }
		    
		    if ( type == HTTPType.Post )
		    {
		    	wr.close();
		    }
		    rd.close();
		    
		    HandleResponse(null,json, callback);
		    
		    //callback.function(null, json);
		} catch (Exception e) {
			HandleResponse(e,null, callback);
			//callback.function(e,"");
		}
	}
	
	public static <T> void HandleResponse(Exception ex, String json, CallbackFunction<T> callback)
	{
		T parsedObj = null;
		if ( ex == null && json != null )
		{
			parsedObj = ParseJson(json);
		}
		callback.function(ex, parsedObj);
	}
	
	public static <T> T ParseJson(String json)
	{
		return null;
	}
}
