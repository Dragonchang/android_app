package com.example.testfl2;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.content.Context;
import android.view.ViewGroup;
import android.app.Service;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.service.notification.NotificationListenerService;
import android.os.AsyncTask;
import TestService.*;

public class SystemUIService extends Service {
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLp;
    public void onCreate() {
        super.onCreate();
        Log.i("testzfl2","SystemUIService onCreate");
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
       /* View mStatusBarWindow = View.inflate(this,
                R.layout.super_status_bar, null);
        mLp =  new WindowManager.LayoutParams (
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_FULLSCREEN,
				0);
        mLp.gravity = Gravity.CENTER;
        mLp.setTitle ("SystemUI");
        mWindowManager.addView(mStatusBarWindow, mLp);*/
    }
    
    public  ITestService.Stub mBinder = new ITestService.Stub() {
        @Override
        public void test() {
        	Log.i("testzfl2","ITestService test*****");
         }
    };    
	@Override
	public IBinder onBind(Intent arg0) {
		Log.i("testzfl2","SystemUIService onBind");
		// TODO Auto-generated method stub
		return mBinder;
	}
    public void onStart(Intent intent, int startId) {
    	Log.i("testzfl2","SystemUIService onStart");
    }	
    public int onStartCommand(Intent intent, int flags, int startId) {
    	Log.i("testzfl2","SystemUIService onStartCommand");
       return super.onStartCommand(intent,  flags,  startId);
    }	
    public void onDestroy() {
    	Log.i("testzfl2","SystemUIService onDestroy");
    }
    
    public boolean onUnbind(Intent intent) {
    	mBinder = null;
    	Log.i("testzfl2","SystemUIService onUnbind");
       return false;
    }
    public void onRebind(Intent intent) {
    	Log.i("testzfl2","SystemUIService onRebind");
    }    

}
