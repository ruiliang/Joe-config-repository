package com.Joe.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeUsernameActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_username);
		
		TextView currentusername = (TextView) findViewById(R.id.current_username);
		final EditText newusername = (EditText) findViewById(R.id.new_username);
		Button confirm = (Button) findViewById(R.id.confirm);
		final String user = getIntent().getStringExtra("username");
		final String ps = getIntent().getStringExtra("password");
		final String resultcount = Preferences.retrieveValue(ChangeUsernameActivity.this, "resultCount", "0");
		currentusername.setText(user);
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (newusername.getText().toString().isEmpty()){
					Toast.makeText(ChangeUsernameActivity.this, "Missing Value, please enter all fields", Toast.LENGTH_SHORT).show();
				}else if (newusername.getText().toString().equals(getIntent().getStringExtra("username"))){
					Toast.makeText(ChangeUsernameActivity.this, "Your new username is same as your current username", Toast.LENGTH_SHORT).show();
				}else if (Preferences.checkUsername(ChangeUsernameActivity.this, resultcount, newusername.getText().toString())){
					Toast.makeText(ChangeUsernameActivity.this, "Your new username has been taken by other user. Please try another one", Toast.LENGTH_SHORT).show();
				}
				else{
					String key = Preferences.getKey(ChangeUsernameActivity.this, resultcount, user+'_'+ps);
					
					Preferences.storeValue(ChangeUsernameActivity.this, key, newusername.getText().toString() + "_" + ps);
					Toast.makeText(ChangeUsernameActivity.this, "Username is Changed", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(ChangeUsernameActivity.this, HomePageActivity.class);
					intent.putExtra("username", newusername.getText().toString());
					intent.putExtra("password", ps);
					startActivity(intent);
					finish();
					
				}
			}
		});
	}

}
