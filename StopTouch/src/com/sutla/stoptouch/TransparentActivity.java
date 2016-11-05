package com.sutla.stoptouch;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class TransparentActivity  extends Service { //extends InputMethodService
	private WindowManager windowManager;
	private TextView chatHead;
	int floattext;
	int progress;
	  
	@SuppressLint("NewApi")
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressLint("NewApi")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    floattext =intent.getIntExtra("float",0);
	    progress = intent.getIntExtra("visible",200);
	    windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
	    if (chatHead != null) windowManager.removeView(chatHead);
	    chatHead = new TextView(this);
	    chatHead.setBackgroundResource(R.drawable.old_android_head);
	    int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    	  if (actionBarTitleId > 0) {
    		  LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    		  View layout = inflater.inflate(R.layout.activity_transparent, null);
    	      TextView title = (TextView)layout. findViewById(actionBarTitleId);
    	      if (title != null) {
    	          title.setTextColor(Color.RED);
    	      }
    	  }
	    //controls visibility of the strip
    	 chatHead.setBackgroundColor(getResources().getColor(R.color.trans));
	    chatHead.setAlpha(1);

	    Log.d("Sau ","diss "+floattext);
	    final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
	        WindowManager.LayoutParams.MATCH_PARENT,
	        150,
	        WindowManager.LayoutParams.TYPE_PHONE,
	        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
	        PixelFormat.TRANSLUCENT);
	    params.gravity = Gravity.TOP ;
	    params.y = floattext ;
	    

	    windowManager.addView(chatHead, params);
	    return START_STICKY;
	}	
	  @Override
	  public void onDestroy() {
	    super.onDestroy();
	    if (chatHead != null) windowManager.removeView(chatHead);
	  }
}