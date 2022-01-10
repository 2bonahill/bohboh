package com.bravobene.bohbohfree;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bravobene.bohbohfree.R;

public abstract class BohbohPage extends Activity {

	protected final Integer ANIMATION_DURATION = 166;

	/*
	 * variables for the animation setup
	 * 
	 * an arraylist containing the videos. it will be filled out by its direct
	 * subclasses in the onCreate() method
	 */
	protected ArrayList<AnimationResource> animationResources = new ArrayList<AnimationResource>();
	protected int numberOfResources;

	/*
	 * first item of the menu
	 */
	protected static final int HOME_ID = Menu.FIRST;

	/*
	 * dialog if the version is no pro
	 */
	protected boolean AVAILABLE_IN_FREE_VERSION = false;
	protected final int DIALOG_BLOCKED = 0;

	/*
	 * the view layout underlying this activity. it will be set by its direct
	 * subclasses in the onCreate() method
	 */
	protected int contentViewLayout;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * by now, the contentViewLayout will be overwritten by the direct
		 * subclass
		 */
		setContentView(this.contentViewLayout);

		// scale the layout and the background image
		RelativeLayout l = (RelativeLayout) findViewById(R.id.relativeLayout1);
		l.setScaleX(Bohboh.scaleRatio);
		l.setScaleY(Bohboh.scaleRatio);

		/*
		 * now set up the animations
		 */
		animationInit();

		/*
		 * do the fine tuning
		 */
		afterCreate();

		// is this the free version?
		if (Bohboh.FREE_VERSION) {
			if (!AVAILABLE_IN_FREE_VERSION) {
				showDialog(0);
			}
		}
	}

	protected void animationInit() {

		// store number of animation resources
		this.numberOfResources = animationResources.size();

		// some placeholder
		AnimationResource animationResource;
		ImageView imageView;
		Button btn;

		// loop through the the arraylist containing the videoclips
		for (int i = 0; i < numberOfResources; i++) {
			/*
			 * get the current animation resource containing - the id of the
			 * imageView - id of the animationlist (=xml file in res/drawable/)
			 * - audioSourceId
			 */
			animationResource = animationResources.get(i);

			/*
			 * create imageView and store it globally
			 */
			imageView = (ImageView) findViewById(animationResource.imageViewId);

			/*
			 * set the onTouch listener. if clicked on the videoView, the video
			 * should be played exactly once. it must not be possible to stop or
			 * pause the video once it has started
			 */
			if (animationResource.buttonId != 0) {
				// use button as touch listener
				btn = (Button) findViewById(animationResource.buttonId);
				btn.setOnClickListener(new BohbohOnTouchListener(this,
						animationResource, imageView));
			} else {
				// use image as touchlistener
				imageView.setOnTouchListener(new BohbohOnTouchListener(this,
						animationResource, imageView));
			}
		}

	}

	/*
	 * now some abstract methods
	 */
	abstract protected void setAnimationResources();

	/*
	 * the following method converts a typedArray to an int array
	 */
	protected int[] convertTypedArray(TypedArray ta) {
		int[] result = new int[ta.length()];
		for (int i = 0; i < ta.length(); i++) {
			result[i] = ta.getResourceId(i, R.drawable.farm_bobo_frame001);
		}
		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean result = super.onCreateOptionsMenu(menu);
		menu.add(0, HOME_ID, 0, "Home");
		return result;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case HOME_ID:
			setResult(RESULT_OK);
			finish();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
		finishActivity(0);
	}

	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(
				"Get the full BOH BOH experience at Google Play Store")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								String APP_MARKET_URL = "market://details?id=com.bravobene.bohboh";

								Intent intent = new Intent(Intent.ACTION_VIEW,
										Uri.parse(APP_MARKET_URL));
								BohbohPage.this.finish();
								BohbohPage.this.startActivity(intent);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						BohbohPage.this.finish();
					}
				});
		AlertDialog alert = builder.create();
		return alert;
	}

	/*
	 * my toaster
	 */
	public void toast(String text) {
		Toast toast = Toast.makeText(BohbohPage.this, text, Toast.LENGTH_SHORT);
		toast.show();
	}

	/*
	 * this is a method to do the fine tuning on the screen
	 */
	abstract protected void afterCreate();

}
