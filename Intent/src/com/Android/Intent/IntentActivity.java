package com.Android.Intent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.drm.DrmStore.Action;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends Activity {
	private Button mainbtn=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mainbtn=(Button)findViewById(R.id.mainbtn);
        mainbtn.setOnClickListener((android.view.View.OnClickListener) listener);
    }
    private OnClickListener listener = new OnClickListener(){


		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			//打电话实现了意图
//			Intent intent=new Intent();
//			intent.setAction(Intent.ACTION_CALL);
//			intent.setData(Uri.parse("tel:10086"));
//			startActivity(intent);
			
			Intent intent=new Intent();
			intent.setClass(IntentActivity.this, SecondActivity.class);
			startActivity(intent);
		}

		
    	
    };
}