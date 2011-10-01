package com.shadygames.droidsvsapples.webservices.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class WebService {
	private static Gson gson = new Gson();
	private static final String WEB_URL = "http://reach.wolfgang.com/";
	
	public enum HTTPType {
		Get, Post
	}
	
	public interface CallbackFunction<T> {
		void function(Exception ex, T jsonObject);
	}
	
	private static class ThreadedClass<T> implements Runnable {
		CallbackFunction<T> callback;
		HTTPType type;
		String request;
		Object obj;
		Class<T> retType;
		
		public ThreadedClass(CallbackFunction<T> _callback, HTTPType _type, String _request, Object _obj, Class<T> _retType)
		{
			callback = _callback;
			type = _type;
			request = _request;
			obj = _obj;
			retType = _retType;
		}
		
		public void run() {
			SendRequest(callback, type, request, obj, retType);
		}
	}
	
	public static <T> void SendAsync(CallbackFunction<T> callback, HTTPType type, String request, Object obj, Class<T> retType)
	{
		new Thread(
				new ThreadedClass<T>(callback, type, request, obj, retType)
		).start();
		
	}
	
	public static <T> void SendSync(CallbackFunction<T> callback, HTTPType type, String request, Object obj, Class<T> retType)
	{
		SendRequest(callback, type, request, obj, retType);
	}
	
	private static <T> void SendRequest(CallbackFunction<T> callback, HTTPType type, String request, Object obj, Class<T> retType)
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
		    conn.addRequestProperty("content-type", "application/json");
		    conn.addRequestProperty("accept-types", "application/json");
		    if ( type == HTTPType.Post )
		    {     
		    	conn.setDoOutput(true);
		    	wr = new OutputStreamWriter(conn.getOutputStream());
		    	wr.write(data);
		    	wr.flush();
		    }

		    // Get the response
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "ISO-8859-1"));
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
		    
		    json = json.substring(3);
		    
		    System.out.println("json" + json);
		    
		    HandleResponse(null,json, callback, retType);
		    
		    //callback.function(null, json);
		} catch (Exception e) {
			//HandleResponse(e,null, callback, retType);
			callback.function(e,null);
		}
	}
	
	public static <T> void HandleResponse(Exception ex, String json, CallbackFunction<T> callback, Class<T> retType)
	{
		T parsedObj = null;
		if ( ex == null && json != null )
		{
			try {
				parsedObj = ParseJson(json, retType);
				callback.function(ex, parsedObj);
				return;
			} catch (Exception e) {
				callback.function(e, null);
				return;
			}
		}
		callback.function(ex, null);
	}
	
	public static <T> T ParseJson(String json, Class<T> retType) throws JsonSyntaxException, InstantiationException, IllegalAccessException
	{
		Gson gson = new Gson();
		return gson.fromJson(json, retType);
	}
}
