package com.codewaffles.nfccontacts;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NFCContacts extends IntentService {

	public NFCContacts(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Context context = getApplicationContext();
		CharSequence text = "Service initiated!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		Log.i("NFCContacts", "> Intent handled!");
	}

}
