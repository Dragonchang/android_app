package com.example.testfl2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Log.i("testzfl","TestReceiver onReceive");
		// TODO Auto-generated method stub
  	  Intent intent = new Intent();
      ComponentName mPlatLogoActivity = new ComponentName("com.example.testfl2",
              "com.example.testfl2.Test2Activity");
      intent.setComponent(mPlatLogoActivity);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(intent );
	}
}
