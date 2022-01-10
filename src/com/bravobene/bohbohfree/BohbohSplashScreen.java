package com.bravobene.bohbohfree;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.VideoView;

public class BohbohSplashScreen extends Activity {

	protected boolean _active = true;
	protected int _splashTime = 6000;
	
	public VideoView myVideoView;
	
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
		setContentView(R.layout.bohbohsplash);

		computeDisplayMetrics();
		
		
		
       
        /*
         * play movie
         */
        playVideo();
        
		// thread for displaying the SplashScreen
//		Thread splashTread = new Thread() {
//			@Override
//			public void run() {
//				try {
//					int waited = 0;
//					while (_active && (waited < _splashTime)) {
//						sleep(100);
//						if (_active) {
//							waited += 100;
//						}
//					}
//				} catch (InterruptedException e) {
//					// do nothing
//				} finally {
//					finish();
//					startActivity(new Intent(BohbohSplashScreen.this, Bohboh.class));
//				}
//			}
//		};
//		splashTread.start();
	}

	private void playVideo() {
		myVideoView = (VideoView) findViewById(R.id.videoView1);
		
		Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro_prores_1024);
		
		myVideoView.setVideoURI(myUri);
		myVideoView.setAlpha(1);
		myVideoView.bringToFront();
		
		myVideoView.setPivotX(0);
		myVideoView.setPivotY(0);
		myVideoView.setScaleX(scaleRatio);
		myVideoView.setScaleY(scaleRatio);
		
		myVideoView.setOnCompletionListener(new OnCompletionListener(){

			@Override
			public void onCompletion(MediaPlayer mp) {
				finish();
				startActivity(new Intent(BohbohSplashScreen.this, BohBohLoadingScreen.class));
			}
			
		});
		
		myVideoView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				VideoView mv = (VideoView) v;
				mv.stopPlayback();
				finish();
				startActivity(new Intent(BohbohSplashScreen.this, BohBohLoadingScreen.class));
				return false;
			}
		});

		myVideoView.requestFocus();
		myVideoView.start();
		
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