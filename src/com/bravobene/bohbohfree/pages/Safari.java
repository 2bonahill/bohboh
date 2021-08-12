package com.bravobene.bohbohfree.pages;

import android.os.Bundle;

import com.bravobene.bohbohfree.AnimationResource;
import com.bravobene.bohbohfree.BohbohPage;
import com.bravobene.bohbohfree.R;

public class Safari extends BohbohPage {
	
	
	/*
	 * this method fills out the VideoResource Array of the
	 * superclass StoryBookPage
	 */
	protected void setAnimationResources(){
		
		/**
		 * the elefant
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_elefant, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_elefant)), 
				R.raw.elefant, "ELEFANT", 0
			));
		
		/**
		 * the lion
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_lion, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_lion)), 
				R.raw.lion, "LION", 0
			));
		
		/**
		 * the zebra
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_zebra, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_zebra)), 
				R.raw.zebra, "ZEBRA", 0
			));
		
		/**
		 * the rhino
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_rhino, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_rhino)), 
				R.raw.rhino, "RHINO", 0
			));
		
		/**
		 * the hippo
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_hippo, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_hippo)), 
				R.raw.hippo, "HIPPO", 0
			));
		
		/**
		 * the giraffe
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_giraffe, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_giraffe)), 
				R.raw.giraffe, "GIRAFFE", 0
			));
		
		/**
		 * the buffalo
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_buffalo, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_buffalo)), 
				R.raw.buffalo, "BUFFALO", 0
			));
		
		/**
		 * the BOHBOH
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_bohboh, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_bohboh)), 
				R.raw.bohboh, "BOHBOH", R.id.btn_safari_bohboh
			));
		
		/**
		 * the gazelle
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_gazelle, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_gazelle)), 
				R.raw.gazelle, "GAZELLE", R.id.btn_safari_gazelle
			));
		
		/**
		 * the leo
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_safari_leo, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_safari_leo)), 
				R.raw.leo, "LEO", 0
			));
		
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//setContentView(this.contentViewLayout);
		this.contentViewLayout = R.layout.safari;
		
		// is this level available for non-pro-version?
		this.AVAILABLE_IN_FREE_VERSION = false;
		
		// set the video resources
		this.setAnimationResources();
		
		//call the onCreate method of StoryBookPage
		super.onCreate(savedInstanceState);
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.creendo.bobo.BoboPage#afterCreate()
	 */
	protected void afterCreate() {
		// TODO Auto-generated method stub
		
	}
	
}
