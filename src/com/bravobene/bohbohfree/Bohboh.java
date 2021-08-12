package com.bravobene.bohbohfree;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bravobene.bohbohfree.R;
import com.bravobene.bohbohfree.pages.Farm;
import com.bravobene.bohbohfree.pages.Jungle;
import com.bravobene.bohbohfree.pages.Safari;

public class Bohboh extends Activity {

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		this.finish();
		
	}

	/*
	 * IMPORTANT:
	 * 
	 * TOGGLE FOR FREE VERSION
	 */
	public static final boolean FREE_VERSION = true;

	public static final String logTag = "StoryBook";

	public static ProgressDialog dialog;

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

		// set the main content view
		setContentView(R.layout.main);

		computeDisplayMetrics();
		
		LinearLayout l = (LinearLayout) findViewById(R.id.LinearLayout1);
		l.setPivotX(0);
		l.setPivotY(0);
		l.setScaleX(Bohboh.scaleRatio);
		l.setScaleY(Bohboh.scaleRatio);
		
				/*
		 * farm
		 */
		Button btn = (Button) findViewById(R.id.main_farm);
		btn.setPivotX(0);
//		btn.setScaleY(this.scaleRatio);
//		btn.setScaleX(this.scaleRatio);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bohboh.this, Farm.class);
				startActivity(i);

			}
		});

		/*
		 * jungle
		 */
		Button btn2 = (Button) findViewById(R.id.main_jungle);
		btn2.setPivotX(0);
//		btn2.setScaleY(this.scaleRatio);
//		btn2.setScaleX(this.scaleRatio);
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bohboh.this, Jungle.class);
				startActivity(i);

			}
		});

		/*
		 * safari
		 */
		Button btn3 = (Button) findViewById(R.id.main_safari);
		btn3.setPivotX(0);
//		btn3.setScaleY(this.scaleRatio);
//		btn3.setScaleY(this.scaleRatio);
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bohboh.this, Safari.class);
				startActivity(i);

			}
		});

	}

	/*
	 * compute display metrices
	 */
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

	/*
	 * my toaster
	 */
	public void myToast(String text) {
		Toast toast = Toast.makeText(Bohboh.this, text, Toast.LENGTH_SHORT);
		toast.show();
	}
}