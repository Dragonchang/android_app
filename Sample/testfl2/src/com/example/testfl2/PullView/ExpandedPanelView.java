package com.example.testfl2.PullView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ExpandedPanelView extends PanelView {
	public static final String TAG = "testzfl2:ExpandedPanelView";
    public ExpandedPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        final float x = event.getX(0);
        final float y = event.getY(0);
        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
       	 mInitialTouchX = x;
       	 mInitialTouchY = y;
       	 mIsTouchPanel = true;
      	  break;
        case MotionEvent.ACTION_POINTER_UP:
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
      	     if (mIsTouchPanel) {
    	         updatePanel(event);
    	      }
            break;

        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
        	mIsTouchPanel = false;
      	  break;
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final float x = event.getRawX();
        final float y = event.getRawY();
        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
       	 mInitialTouchX = x;
       	 mInitialTouchY = y;
       	 mIsTouchPanel = true;
      	  break;
        case MotionEvent.ACTION_POINTER_UP:
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
      	     if (mIsTouchPanel) {
    	         updatePanel(event);
    	      }
            break;

        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
        	mIsTouchPanel = false;
      	  break;
        }
         return true;
    }
    
    protected void updateTouchPanel(MotionEvent event) {
    	Log.i(TAG,"updateTouchPanel");
 	   if (mViewControl != null) {
		   mViewControl.updateTouchPanel(event);
	   }
    }
    
    protected void updateLayout(float left, float top, float right, float bottom) {
		   if (getVisibility() != View.VISIBLE) {
               setVisibility(View.VISIBLE);
		   }
		   int MoveDirectionMode = mViewControl.getDirectionMode();
		   if (MoveDirectionMode == 1) {
			   Log.i(TAG,"updateTouchPanel left = "+left+"top - getHeight = "+(top - getHeight())+"right = "+right+"top= "+top);
	          layout((int)left, (int)top - getHeight(),
	            		(int)right, (int)top);
		   } else if(2 == MoveDirectionMode) {
			   
		   } else {
			   
		   }

    }

}
