package com.codewaffles.nfccontacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends Activity {
private Intent service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("MainActivity", "NFCContacts App running");
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		service = new Intent(this, NFCContacts.class);
	
		Button btn_start = (Button) findViewById(R.id.btn_start);
		Button btn_stop = (Button) findViewById(R.id.btn_stop);
		
	
		btn_start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("MainActivity", "Service NFCContacts Started");
	            startService(service);
			}
		});
	
		btn_stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("MainActivity", "Service NFCContacts Stopped");
	            stopService(service);
			}
		});
	}

}
