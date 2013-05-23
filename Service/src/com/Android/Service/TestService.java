package com.Android.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
	
	private final String TAG="TestService";
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "TestService-->onCreat");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "TestService-->onStartCommand");
		//return super.onStartCommand(intent, flags, startId);
		return START_NOT_STICKY;
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "TestService-->onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
