package com.bravobene.bohbohfree;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class BohbohOnTouchListener implements OnTouchListener, OnClickListener {

	private Context context;
	private AnimationResource animResource;
	private int[] frameList;
	private AnimationDrawable d;
	protected final static Integer ANIMATION_DURATION = 166;
	private ImageView imageView;
	private MediaPlayer mediaPlayer;
	private int overallDuration;
	private Handler mHandler;
	private boolean animationIsPlaying = false;
	public static int currentPlays = 0;
	public final int maxPlays = 1;

	public BohbohOnTouchListener(Context c, AnimationResource animResource,
			ImageView v) {
		this.context = c;
		this.animResource = animResource;
		this.frameList = animResource.frameList;
		d = new AnimationDrawable();
		this.imageView = v;
		if (animResource.audioSourceId != 0) mediaPlayer = MediaPlayer.create(context, animResource.audioSourceId);
		
		overallDuration = (frameList.length + 1) * ANIMATION_DURATION;
		mHandler = new Handler();

	}

	/**
	 * for the imageview ontouchlistener
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		go(v);
		return false;
	}
	
	/**
	 * for the button onclicklistener
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.go(v);
		
	}
	
	public void go(View v){
		// this is ugly: animationdrawable does not reset it's state after
		// finishing playing. so we
		// have to use the sound player as an indicator
		if (!animationIsPlaying && currentPlays < maxPlays){
			animationIsPlaying = true;
			currentPlays++;
			new AsyncAnimationLoader().execute();
		}
	}

	/**
	 * 
	 * @author tobiasambuhl
	 * 
	 *         async frame loader
	 * 
	 */
	public class AsyncAnimationLoader extends AsyncTask<Void, Integer, Long> {

		protected void onPreExecute() {
		}

		/*
		 * 
		 */
		protected Long doInBackground(Void... items) throws OutOfMemoryError {

			for (int f = 0; f < frameList.length; f++) {
				d.addFrame(context.getResources().getDrawable(frameList[f]),
						ANIMATION_DURATION);

			}

			return 0L;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Long result) {
			/*
			 * play audio only if defined
			 */
			startSound();

			// start animation
			imageView.setImageBitmap(null);
			imageView.setBackgroundDrawable(d);

			// AnimationDrawable does not support listeners. We have to use
			// Android'd Handler (which can change on the UI)
			mHandler.postDelayed(new OnAnimationEndTask(), overallDuration);

			d.start();
			
			// imageView.setBackgroundDrawable(d);
			d.setOneShot(true);

		}
	}

	/*
	 * The listener to the AnimationDrawable's end
	 */
	class OnAnimationEndTask implements Runnable {
		public void run() {
			d = new AnimationDrawable();
			imageView.setBackgroundDrawable(context.getResources().getDrawable(
					frameList[0]));
			animationIsPlaying = false;
			currentPlays--;
			if (currentPlays < 0) currentPlays = 0;
			System.gc();
		}

	}

	protected void startSound() {
		playSound(true);
	}

	protected void stopSound() {
		playSound(false);
	}

	protected void playSound(boolean start) {
		if (animResource.audioSourceId != 0) {

			if (start) {
				if (!mediaPlayer.isPlaying())
					mediaPlayer.start(); // no need to call prepare(); create()
											// does
											// that for you
			} else {
				mediaPlayer.stop();
				mediaPlayer = MediaPlayer.create(context,
						animResource.audioSourceId);

			}
		}
	}

}
