package com.Joe.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		final EditText username = (EditText) findViewById(R.id.login_username);
		final EditText password = (EditText) findViewById(R.id.login_password);
		final Button signup = (Button) findViewById(R.id.sign_up);
		Button signin = (Button) findViewById(R.id.sign_in);

		signin.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {

				String user = username.getText().toString();
				String pw = password.getText().toString();
				
				String resultCount = Preferences.retrieveValue(LoginActivity.this, "resultCount", "0");

				if(user.isEmpty() || pw.isEmpty())
				{
					Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
				}
				else if(Preferences.checkForExistingUser(LoginActivity.this, resultCount, user+'_'+pw))
				{
					Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
					intent.putExtra("username", user);
					intent.putExtra("password", pw);
					startActivity(intent);
					finish();
				}
				else 
				{
					Toast.makeText(LoginActivity.this, "You Username or password is not match with our record, please try it again", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, RegistarActivity.class);
				startActivity(intent);
			}
		});

	}

}
