package com.codewaffles.nfccontacts;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NFCContacts extends IntentService {

	public NFCContacts() {
		this("NFCContacts");
	}
	
	public NFCContacts(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("NFCContacts", "> Intent handled!");
	}

}
