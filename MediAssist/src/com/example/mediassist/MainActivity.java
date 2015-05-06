package com.example.mediassist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout alarmLayout = (LinearLayout) findViewById(R.id.alarm_layout);
		alarmLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showAlarmActivity();
				
			}
		});
		LinearLayout contactLayout = (LinearLayout) findViewById(R.id.contact_layout);
		contactLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showContactActivity();
				
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
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void showAlarmActivity(){
		Intent intent = new Intent(this, AlarmActivity.class);
		
		//intent.putExtra("time","FirstKeyValue");
	    startActivity(intent);

	}
	public void showContactActivity(){
		Intent intent = new Intent(this, ContactActivity.class);
		
		//intent.putExtra("time","FirstKeyValue");
	    startActivity(intent);

	}
}
