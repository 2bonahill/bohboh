package com.bravobene.bohbohfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bravobene.bohbohfree.R;

public class BohBohLoadingScreen extends Activity {

	protected boolean _active = true;
	protected int _splashTime = 6000;
	
	public VideoView myVideoView;
	public Thread splashThread;
	
	/*
	 * some data w.r.t. to display metrics
	 */
	public static final int OPTIMAL_SCREEN_WIDTH = 1280;
	public static final int OPTIMAL_SCREEN_HEIGHT = 720;
	public static float scaleRatio;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bohbohloading);

		computeDisplayMetrics();
		
		ImageView i = (ImageView) findViewById(R.id.imageView1);
//		i.setScaleX(scaleRatio);
//		i.setScaleY(scaleRatio);
		
		i.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				splashThread.interrupt();
				//goToNextActivity();
				return false;
			}});
       
        
		// thread for displaying the SplashScreen
		splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					Log.v("BOBO", "finally");
					goToNextActivity();
				}
			}
		};
		splashThread.start();
	}
	
	public void goToNextActivity(){
		finish();
		startActivity(new Intent(BohBohLoadingScreen.this, Bohboh.class));
	}

	
	
	private void computeDisplayMetrics() {
		// get the display metrics
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		/*
		 * get screen dimensions for image adjustments
		 */
		Display display = getWindowManager().getDefaultDisplay();
		float screenWidth = display.getWidth();
		float screenHeight = display.getHeight();
		float widthRatio = (float) screenWidth / OPTIMAL_SCREEN_WIDTH;
		float heightRatio = (float) screenHeight / OPTIMAL_SCREEN_HEIGHT;

		/*
		 * so now the big question: where is the image full-screen?
		 * 
		 * if (screenWidth/OPTIMAL_SCREEN_WIDTH) > (screenHeight /
		 * OPTIMAL_SCREEN_HEIGHT) -> we have to scale the image down along the Y
		 * axes.
		 */
		this.scaleRatio = Math.min(widthRatio, heightRatio) / metrics.density;

	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		if (event.getAction() == MotionEvent.ACTION_DOWN) {
//			_active = false;
//		}
//		return true;
//	}
}