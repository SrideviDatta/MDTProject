package com.example.mediassist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class LVActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarmlist);
		
		final LVActivity lact = this;
		
		Intent intent = getIntent();
		    ArrayList<Alarm> aList  = intent.getExtras().getParcelableArrayList("al");
		ListView lv = (ListView)findViewById(R.id.listViewTasks);
	    System.out.println("lv is "+lv);
	    AlarmAdapter la = new AlarmAdapter(this,android.R.layout.simple_list_item_1,aList);
	    lv.setAdapter(la);
	    final Button backBtn = (Button) findViewById(R.id.btnBack);
	    backBtn.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	Intent intent = new Intent(lact, AlarmActivity.class);
	     	    startActivity(intent);
	        }
	    });
	}
	
	
    
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lv, menu);
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
}
