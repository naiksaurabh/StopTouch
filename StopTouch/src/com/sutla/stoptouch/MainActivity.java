package com.sutla.stoptouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnSeekBarChangeListener{
	
	Button b,b1;
	EditText et;
	SeekBar sb;
	int progress=200;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  // Now set up content view
		setContentView(R.layout.activity_main);
		    	
		b1 = (Button)findViewById(R.id.button1);
		b = (Button)findViewById(R.id.button2);
		et = (EditText)findViewById(R.id.editText1);
		sb = (SeekBar)findViewById(R.id.seekBar1);
		b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i=  new Intent(MainActivity.this, TransparentActivity.class);
            	int fg = 250;
            	try{
            		fg = Integer.parseInt(et.getText().toString());
            	}
            	catch(Exception e){}
            	i.putExtra("float", fg);
            	i.putExtra("visible", progress);
            	startService(i); 
            }
        });
		b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	stopService(new Intent(MainActivity.this, TransparentActivity.class));

               
            }
	});
}


	@Override
	public void onProgressChanged(SeekBar arg0, int prog, boolean arg2) {
		// TODO Auto-generated method stub
		progress = prog;
	}


	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
