package com.Joe.login;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistarActivity extends Activity {

	EditText username;
	EditText password;
	EditText confirmPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.username = (EditText) findViewById(R.id.login_username);
		this.password = (EditText) findViewById(R.id.login_password);
		this.confirmPassword = (EditText) findViewById(R.id.confirmpassword);
		Button submit = (Button) findViewById(R.id.submit);

		submit.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {

				String user = username.getText().toString();
				String pass1 = password.getText().toString();
				String pass2 = confirmPassword.getText().toString();

				if(user.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
					Toast.makeText(RegistarActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
				}else if(pass1.equals(pass2)){

					String resultCount = Preferences.retrieveValue(RegistarActivity.this, "resultCount", "0");

					if(!(Preferences.checkUsername(RegistarActivity.this, resultCount, user))){

						int i = Integer.parseInt(resultCount);
						i++;
						resultCount = String.valueOf(i);

						Preferences.storeValue(RegistarActivity.this, "resultCount", resultCount);
						Preferences.storeValue(RegistarActivity.this, resultCount, user+'_'+pass1);

						Intent intent = new Intent(RegistarActivity.this, HomePageActivity.class);
						intent.putExtra("username", user);
						intent.putExtra("password", pass1);
						startActivity(intent);
						finish();

					}
					else {
						Toast.makeText(RegistarActivity.this, "Username has been taken. Please try again", Toast.LENGTH_SHORT).show();
					}
				}	
				else{
					Toast.makeText(RegistarActivity.this, "Confirm Password is not match with your password", Toast.LENGTH_SHORT).show();
				}
			}

		});
	}
}
