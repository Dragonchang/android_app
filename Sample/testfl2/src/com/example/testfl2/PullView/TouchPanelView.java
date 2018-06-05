package com.example.testfl2.PullView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.graphics.Rect;
public class TouchPanelView extends PanelView {
	public static final String TAG = "testzfl2:TouchPanelView";
    public TouchPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
   @Override
   public boolean onInterceptTouchEvent(MotionEvent event) {
    	Log.i(TAG,String.format("onInterceptTouchEvent at (%d,%d)",(int) event.getX(), (int) event.getY()));
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
        return super.onInterceptTouchEvent(event);
    }
   @Override
   public boolean onTouchEvent(MotionEvent event) {
    	  //针对
    	  Log.i(TAG,String.format("onTouchEvent at (%d,%d)",(int) event.getX(), (int) event.getY())); 
          final float x = event.getRawX();
          final float y = event.getRawY();
          switch (event.getActionMasked()) {
          case MotionEvent.ACTION_DOWN:
        	 Log.i(TAG,String.format("ACTION_DOWN at (%d,%d)",(int) event.getX(), (int) event.getY())); 
         	 mInitialTouchX = x;
         	 mInitialTouchY = y;
         	 mIsTouchPanel = true;
        	  break;
          case MotionEvent.ACTION_POINTER_UP:
              break;
          case MotionEvent.ACTION_POINTER_DOWN:
              break;
          case MotionEvent.ACTION_MOVE:
        	     Log.i(TAG,String.format("ACTION_MOVE at (%d,%d)",(int) event.getX(), (int) event.getY())); 
        	     if (mIsTouchPanel) {
      	         updatePanel(event);
      	      }
              break;

          case MotionEvent.ACTION_UP:
          case MotionEvent.ACTION_CANCEL:
          	  mIsTouchPanel = false;
        	  break;
          }
         
         return  super.onTouchEvent(event);
    } 
   
   protected void updateExpandedPanel(MotionEvent event) {
	   Log.i(TAG,"updateExpandedPanel");
	   Log.i(TAG,"updateExpandedPanel getLeft() = "+getLeft()+"getTop() = "+getTop()+"getRight() = "+getRight()+"getBottom() = "+getBottom());
	   Log.i(TAG,"updateExpandedPanel getPaddingLeft() = "+getPaddingLeft()+"getPaddingTop() = "+getPaddingTop()+"getPaddingBottom() = "+getPaddingBottom()+"getPaddingRight"+getPaddingRight());
	   //final Rect outRect = new Rect();
	   //getBoundsOnScreen(outRect);
	   float left = getLeft();
	   float top = getTop();
	   float right = getRight();
	   float bottom = getBottom();
	   if (mViewControl != null) {
		   mViewControl.updateExpandedPanelLayout(left, top, right, bottom);
	   }
   }
   
   protected void updateLayout(float left, float top, float right, float bottom) {

   }

}
