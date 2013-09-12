package com.Joe.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomePageActivity extends Activity{

	EditText user = null;
	String username = null;
	String password = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		this.username = getIntent().getStringExtra("username");
		this.password = getIntent().getStringExtra("password");
		TextView display = (TextView) findViewById(R.id.homepage);
		Button showUser = (Button) findViewById(R.id.showUser);
		display.setText("Welcome " + username);
		
		showUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HomePageActivity.this, ShowAllUserActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		switch (item.getItemId()){

		case R.id.change_username:
			Intent intent = new Intent(HomePageActivity.this, ChangeUsernameActivity.class);
			intent.putExtra("username", username);
			intent.putExtra("password", password);
			startActivity(intent);
			break;
		case R.id.change_password:
			Intent intent2 = new Intent(HomePageActivity.this, ChangePasswordActivity.class);
			intent2.putExtra("username", username);
			intent2.putExtra("password", password);
			startActivity(intent2);
			break;
		}
		return super.onOptionsItemSelected(item);

	}

	public void onBackPressed(){
		// when user hit the back button it will bring user back to the last page
		super.onBackPressed();
		Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
		startActivityForResult(intent, 101);
	}

}
