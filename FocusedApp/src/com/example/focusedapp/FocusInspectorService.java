package com.example.focusedapp;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class FocusInspectorService extends IntentService {

	public FocusInspectorService() {
		this("FocusInspectorService");
		Log.i("FocusInspectorService", "> Focus Inspector Service Started!");
	}

	public FocusInspectorService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("FocusInspectorService", "> Intent Handled!");
		ActivityManager actvityManager = (ActivityManager) this
				.getSystemService(ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> procInfos = actvityManager
				.getRunningAppProcesses();

		for (RunningAppProcessInfo runningProInfo : procInfos) {
			if (runningProInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
				Log.i("Main Process", runningProInfo.processName);
			}
		}
	}

}
