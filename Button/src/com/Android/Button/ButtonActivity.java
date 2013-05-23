package com.Android.Button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends Activity {
	private Button btn1=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(ButtonActivity.this, "Îâ¿­ÊÇ¸ö´ì»õ", Toast.LENGTH_LONG).show();
			}
		});
    }
}