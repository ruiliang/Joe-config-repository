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

public class ChangePasswordActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_password);
		
		TextView currentpassword = (TextView) findViewById(R.id.current_password);
		final EditText newpassword = (EditText) findViewById(R.id.new_password);
		Button confirm = (Button) findViewById(R.id.confirm);
		final String user = getIntent().getStringExtra("username");
		final String ps = getIntent().getStringExtra("password");
		
		currentpassword.setText(ps);
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (newpassword.getText().toString().isEmpty()){
					Toast.makeText(ChangePasswordActivity.this, "Missing Value, please enter all fields", Toast.LENGTH_SHORT).show();
				}else if (newpassword.getText().toString().equals(getIntent().getStringExtra("password"))){
					Toast.makeText(ChangePasswordActivity.this, "Your new password is same as your current password", Toast.LENGTH_SHORT).show();
				}else{
					
					String resultcount = Preferences.retrieveValue(ChangePasswordActivity.this, "resultCount", "0");
					String key = Preferences.getKey(ChangePasswordActivity.this, resultcount, user+'_'+ps);
					
					Preferences.storeValue(ChangePasswordActivity.this, key, user + "_" + newpassword.getText().toString());
					
					Toast.makeText(ChangePasswordActivity.this, "Password is Changed", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(ChangePasswordActivity.this, HomePageActivity.class);
					intent.putExtra("username", user);
					intent.putExtra("password", newpassword.getText().toString());
					startActivity(intent);
					finish();
					
				}
			}
		});
	}

}