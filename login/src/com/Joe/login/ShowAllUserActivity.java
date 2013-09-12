package com.Joe.login;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ShowAllUserActivity extends Activity{


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_all_user);
		
		ListView display = (ListView) findViewById(R.id.list_all_user);
		
		String resultCount = Preferences.retrieveValue(ShowAllUserActivity.this, "resultCount", "0");
		ArrayList<String> allUser = new ArrayList<String>();
		int totalNumberUser = Integer.parseInt(resultCount);
		
		
		for (int i = 0; i <= totalNumberUser; i++){
			allUser.add(Preferences.retrieveValue(ShowAllUserActivity.this, String.valueOf(i), "user"));
		}
		
		UserNameAdapter adapter = new UserNameAdapter(ShowAllUserActivity.this, allUser);
		//display.setAdapter(new ArrayAdapter<String>(ShowAllUserActivity.this, android.R.layout.simple_list_item_1, allUser));
		
		display.setAdapter(adapter);
	
	}
}



