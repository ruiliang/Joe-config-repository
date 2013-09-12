package com.Joe.login;

import org.json.JSONException;
import org.json.JSONObject;

public class Untility {

	public static String data = "{\"coord\":{\"lon\":-83.0711,\"lat\":39.8506},\"sys\":{\"country\":\"United States of America\",\"sunrise\":1376217676,\"sunset\":1376267603},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"base\":\"gdps stations\",\"main\":{\"temp\":300.93,\"pressure\":1018,\"humidity\":58,\"temp_min\":300.15,\"temp_max\":301.48},\"wind\":{\"speed\":3.6,\"deg\":180},\"clouds\":{\"all\":40},\"dt\":1376248524,\"id\":4513409,\"name\":\"Grove City\",\"cod\":200}";
	
	
	public Untility ()
	{
		parseLocationData(this.data);
	}
	
	public void parseLocationData(String locationData)
	{
		try 
		{
			JSONObject jObj = new JSONObject(locationData);
			JSONObject coordObj = getObject("coord", jObj);
			JSONObject sysObj = getObject("sys", jObj);
			
			MyLocation loc = new MyLocation();
			loc.setLattitude(getFloat("lat", coordObj));
			loc.setLongtitude(getFloat("lon", coordObj));
			
			loc.setCountry(getString("country", sysObj));
			loc.setSunrise(getInt("sunrise", sysObj));
			loc.setSunset(getInt("sunset", sysObj));
			loc.setCity(getString("name", jObj));			
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
	    JSONObject subObj = jObj.getJSONObject(tagName);
	    return subObj;
	}
	 
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
	    return jObj.getString(tagName);
	}
	 
	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
	    return (float) jObj.getDouble(tagName);
	}
	 
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
	    return jObj.getInt(tagName);
	}
	
}
