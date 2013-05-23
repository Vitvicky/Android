package com.Android.StatusBar;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StatusBarActivity extends Activity {
	private Button btnStartService;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnStartService=(Button) findViewById(R.id.btnStartService);
        btnStartService.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent= new Intent(StatusBarActivity.this,StatusService.class);
				
			}
		});
        
    }
    public void onStart(){
    	super.onStart();
    	NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	manager.cancel(R.id.btnStartService);
    }
}