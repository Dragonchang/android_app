package com.example.testfl2.PullView;



/***************************
 * 
 * @author archermind
 *作用：
 *决定两个VIEW交互的方向：
 *    1.向上下
 *    2左右
 *为两个view提供交互的桥梁
 *    1.
 */
import android.view.MotionEvent;
public  class ViewControl {
	public enum DIRECTION{
		NODIRECTION,
		UPDOWN,
		LeftRight
	}

	private TouchPanelView mTouchPanelView;
	private ExpandedPanelView mExpandedPanelView;
	private int mDirectionMode;
	public ViewControl (TouchPanelView touchPanelView, ExpandedPanelView expandedPanelView) {
		mTouchPanelView = touchPanelView;
		mExpandedPanelView = expandedPanelView;
		if (mTouchPanelView != null)mTouchPanelView.setViewControl(this);
		if (mExpandedPanelView != null)mExpandedPanelView.setViewControl(this);
	}
	
	private ViewControl.DIRECTION getDirectionModebydir(int direction) {
		switch (direction) {
		   case 1 :
			  return ViewControl.DIRECTION.UPDOWN;
		   case 2 :
			  return ViewControl.DIRECTION.LeftRight;
		}
		return ViewControl.DIRECTION.NODIRECTION;
	}
	
	public int getDirectionMode() {
		return mDirectionMode;//getDirectionModebydir(mDirectionMode);
	}
	
	public void setDirectionMode(int direction) {
		mDirectionMode = direction;
	}
	
	public void updateExpandedPanelLayout(float left, float top, float right, float bottom) {
		if (mExpandedPanelView != null) {
			mExpandedPanelView.updateLayout(left, top, right, bottom);
		}
	}
	
	public void updateTouchPanel(MotionEvent event) {
		
	}
	
}
