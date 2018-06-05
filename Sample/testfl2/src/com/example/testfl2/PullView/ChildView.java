package com.example.testfl2.PullView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class ChildView extends FrameLayout {
	public static final String TAG = "testzfl2:ChildView";	
    public ChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
    
	public boolean onInterceptTouchEvent(MotionEvent event) {
		 Log.i(TAG,"onInterceptTouchEvent");
	     switch (event.getActionMasked()) {
	     case MotionEvent.ACTION_DOWN:
	
	   	  break;
	     case MotionEvent.ACTION_POINTER_UP:
	         break;
	     case MotionEvent.ACTION_POINTER_DOWN:
	         break;
	     case MotionEvent.ACTION_MOVE:
	         break;
	
	     case MotionEvent.ACTION_UP:
	     case MotionEvent.ACTION_CANCEL:
	   	  break;
	     }
	     //
	    return true;
	}
   
   public boolean onTouchEvent(MotionEvent event) {
   	  Log.i(TAG,"onTouchEvent");
         switch (event.getActionMasked()) {
         case MotionEvent.ACTION_DOWN:
       	  break;
         case MotionEvent.ACTION_POINTER_UP:
             break;
         case MotionEvent.ACTION_POINTER_DOWN:
             break;
         case MotionEvent.ACTION_MOVE:
             break;

         case MotionEvent.ACTION_UP:
         case MotionEvent.ACTION_CANCEL:
       	  break;
         }
         //
   	  return false;
   }
}
