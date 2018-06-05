package com.example.testfl2.PullView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PanelView extends FrameLayout {
	public static final String TAG = "testzfl2:PanelView";	
	protected 	ViewControl mViewControl;
	private boolean mIsPanelVisible;
	protected boolean mIsTouchPanel;
	protected int mMoveDirectionMode;
	protected float mInitialTouchX;
	protected float mInitialTouchY;
	protected float mLastTouchX;
	protected float mLastTouchY;	
	protected float mMovevalue;
    
    
    public PanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setViewControl(ViewControl viewcontrol) {
    	mViewControl = viewcontrol;
    }
    
    public void setPanelViewVisible(boolean Visible) {
    	mIsPanelVisible = Visible;
    }
    
    public boolean getPanelViewVisible() {
    	return mIsPanelVisible;
    }
    @Override
    protected void onLayout (boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG,"PanelView onLayout changed ="+changed+"left = "+left+"top = "+top+"right = "+right+"bottom = "+bottom);
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
    	  return true;
    }
    
    protected void fling(float vel, boolean expand, int direction ) {
         
    }
    protected void updatePanel(MotionEvent event) {
    	updatePanelInternel(event);
    	updateTouchPanel(event);
    	updateExpandedPanel(event);
    }
    protected void updatePanelInternel(MotionEvent event) {
        Log.i(TAG,"updatePanelInternel");
    	 //update self
        final float x = event.getX();
        final float y = event.getY();
        
        final float x1 = event.getRawX();
        final float y1 = event.getRawY();
        Log.i(TAG,"updatePanelInternel down and up getX = "+x+"getY = "+y);
        Log.i(TAG,"updatePanelInternel down and up getRawX = "+x1+"getRawY = "+y1);
        Log.i(TAG,"updatePanelInternel down and up getLeft() = "+getLeft()+"getTop() = "+getTop()+"getRight() = "+getRight()+"getBottom() = "+getBottom());
    	 if (mViewControl != null) {
    		mMoveDirectionMode = mViewControl.getDirectionMode();
    	 }
    	 if (1 == mMoveDirectionMode) {
    		Log.i(TAG,"updatePanelInternel down and up ");
    		
    		//移动方法1
    		float h = y1 - mInitialTouchY;
    		final float newHeight = Math.max(0, h);
    		mMovevalue = newHeight;
    		Log.i(TAG,"updatePanelInternel mInitialTouchY = "+mInitialTouchY);
    		Log.i(TAG,"updatePanelInternel y = "+y);
    		Log.i(TAG,"updatePanelInternel h= "+h);
    		Log.i(TAG,"updatePanelInternel newHeight= "+newHeight);
    		//SetLeft：是设置相对于父窗口原点。
    		//setY是设置相对于屏幕原点。
    		//setTranslationY(newHeight);
    		//use y value
    		//invalidate();
    		//移动方法2
            //计算移动的距离
    		int offX = (int)(x - mInitialTouchX);
    		int offY = (int)(y - mInitialTouchY);
    		Log.i(TAG,"updatePanelInternel down and up offX = "+offX+"offY = "+offY);
            //调用layout方法来重新放置它的位置
           layout(getLeft(), getTop()+offY,
              getRight()  , getBottom()+offY);
    	} else if (2 == mMoveDirectionMode){
    		Log.i(TAG,"updatePanelInternel left and right");
    		setY(x);
    		invalidate();
    		//use x value
    	} else {
    		Log.i(TAG,"updatePanelInternel");
    		//do nothing
    	}
    }
    protected void updateTouchPanel(MotionEvent event) {
        // if panel is Touch view do noting
     }
    
    protected void updateExpandedPanel(MotionEvent event) {
        // if panel is Expanded view do noting
    }
    protected void updateLayout(float left, float top, float right, float bottom) {

    }
    
}
