package com.example.testfl;
import android.app.Activity;
import android.os.Bundle;
import android.animation.ValueAnimator;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class AnimatorTestActivity extends Activity {
	public static final String TAG = "AnimatorTestActivity";
	private Button mButton_ValueAnimator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animator);
		mButton_ValueAnimator = (Button)findViewById(R.id.button1);
		mButton_ValueAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        		ValueAnimator animator = createHeightAnimator(0, 500);
        		animator.setDuration(350);
        		animator.start();
            }});

		
	}
    private ValueAnimator createHeightAnimator(float  height,float targetHeight) {
        ValueAnimator animator = ValueAnimator.ofFloat(height, targetHeight);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
              Log.i(TAG, "createHeightAnimator::onAnimationUpdate animation.getAnimatedValue() = "+animation.getAnimatedValue());

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
            	Log.i(TAG, "createHeightAnimator::onAnimationCancel");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            	Log.i(TAG, "createHeightAnimator::onAnimationEnd");
            }
        });
        return animator;
    }
}
