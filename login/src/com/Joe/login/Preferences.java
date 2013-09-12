package com.Joe.login;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

	private static final String PREFILE = "username";
	
	public static void storeValue (Context context, String key, String value){
		
		SharedPreferences setting = context.getSharedPreferences(PREFILE, 0);
		SharedPreferences.Editor editor = setting.edit();
		
		editor.putString(key, value);
		editor.commit();
		
	}
	
	public static String retrieveValue (Context context, String key, String value){
		
		SharedPreferences setting = context.getSharedPreferences(PREFILE, 0);
		String result = setting.getString(key, "0");
		return result;
		
	}
	
	public static boolean checkForExistingUser (Context context, String key, String value){
		
		boolean hasSameUserName = false;
		int keyNum = Integer.parseInt(key);
		
		for (int i = 0; i <= keyNum; i++){
			if (value.equals(retrieveValue(context, String.valueOf(i), value))){
				hasSameUserName = true;
			}
		}
		return hasSameUserName;
	}
	
	public static String getKey (Context context, String resultCount, String value){

		int keyNum = Integer.parseInt(resultCount);
		String key = null;
		for (int i = 0; i <= keyNum; i++){
			String user = retrieveValue(context, String.valueOf(i), value);
			if (value.equals(user)){
				key = String.valueOf(i);
			}

		}
		
		return key;
	}
	
	public static boolean checkUsername (Context context, String key, String value){
		
		String newuser = value + '_';
		boolean hasSameUsername = false;
		int keyNum = Integer.parseInt(key);
		
		for (int i = 0; i <= keyNum; i++){
			if (retrieveValue(context, String.valueOf(i), value).startsWith(newuser)){
				hasSameUsername = true;
			}
		}
		return hasSameUsername;
	}
	
}
