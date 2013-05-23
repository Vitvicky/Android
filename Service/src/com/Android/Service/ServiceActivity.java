package com.Android.Service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceActivity extends Activity {
    private Button BtnStartService;
    private Button BtnStoptService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BtnStartService=(Button)findViewById(R.id.BtnStartService);
        BtnStoptService=(Button)findViewById(R.id.BtnStopService);
        BtnStartService.setOnClickListener(listener);
    }
    
    private OnClickListener listener = new OnClickListener() {
		
		public void onClick(View v) {
			Intent intent = new Intent(ServiceActivity.this,TestService.class);
			switch (v.getId()) {
			case R.id.BtnStartService:
				//Intent intent = new Intent(ServiceActivity.this,TestService.class);
				startService(intent);
				break;
			case R.id.BtnStopService:
				stopService(intent);
				break;
			default:
				break;
			}
			
		}
	};
}