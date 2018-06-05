package com.example.testfl2;

import com.example.testfl2.PullView.ExpandedPanelView;
import com.example.testfl2.PullView.TouchPanelView;
import com.example.testfl2.PullView.ViewControl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.util.Log;
public class Test2Activity extends Activity {
	public static final String TAG = "testzfl2:Test2Activity";
	TouchPanelView mTouchPanelView;
	ExpandedPanelView mExpandedPanelView;
	ViewControl mViewControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test2);
		
		mTouchPanelView = (TouchPanelView)findViewById(R.id.touch_panel);
		mExpandedPanelView = (ExpandedPanelView)findViewById(R.id.expanded_panel);
		mViewControl = new ViewControl(mTouchPanelView, mExpandedPanelView);
		mTouchPanelView.setViewControl(mViewControl);
		mExpandedPanelView.setViewControl(mViewControl);
		mViewControl.setDirectionMode(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test2, menu);
		return true;
	}
	
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }
    
    public boolean onTouchEvent(MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();
        
        final float x1 = event.getRawX();
        final float y1 = event.getRawY();
        Log.i(TAG,"onTouchEvent down and up getX = "+x+"getY = "+y);
        Log.i(TAG,"onTouchEvent down and up getRawX = "+x1+"getRawY = "+y1);
    	  return false;
    }

}
