package com.bravobene.bohbohfree.pages;

import android.os.Bundle;

import com.bravobene.bohbohfree.AnimationResource;
import com.bravobene.bohbohfree.BohbohPage;
import com.bravobene.bohbohfree.R;

public class Farm extends BohbohPage {
	
	
	/*
	 * this method fills out the VideoResource Array of the
	 * superclass StoryBookPage
	 */
	protected void setAnimationResources(){
		
		
		/**
		 * 1) BOBO
		 */
		animationResources.add(	new AnimationResource(
									R.id.imageView_farm_bobo, 
									convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_obo)), 
									R.raw.bobo_theme_long, "BOBO", 0
								));
		
		/**
		 * 2) the cow
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_cow, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_kuh)), 
				R.raw.kuh, "KUH", 0
			));
		
		
		/**
		 * 3) the piggy
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_piggy, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_piggy)), 
				R.raw.piggy, "PIGGY", 0
			));
		
		/**
		 * 4) the sheep
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_sheep, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_sheep)), 
				R.raw.sheep, "SHEEP", 0
			));
		
		
		/**
		 * 4) the gueggl
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_gueggl, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_gueggl)), 
				R.raw.gueggl, "GUEGGL", 0
			));
		
		/**
		 * 5) the horse
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_roessli, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_roessli)), 
				R.raw.roessli, "ROESSLI", 0
			));
	
		/**
		 * 6) the kamin
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_kamin, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_kamin)), 
				0, "KAMIN", 0
			));
		
		/**
		 * 7) the ziege
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_ziege, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_ziege)), 
				R.raw.ziege, "ZIEGE", 0
			));
	
		/**
		 * 8) the goose 2 (window front)
		 */ 
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_gans2, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_gans2)), 
				R.raw.gans, "GANS VORNE", 0
			));
		
		/**
		 * 9) the sun
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_sun, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_sun)), 
				0, "SONNE", R.id.btn_farm_sun
			));
		
		/**
		 * 10) the ducks
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_entli, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_entli)), 
				R.raw.entli, "ENTLI", 0
			));
		
		/**
		 * 11) the goose
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_gans, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_gans)), 
				R.raw.gans, "GANS DACH", 0
			));
		
		/**
		 * 12) the truck
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_traktor, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_traktor)), 
				R.raw.traktor, "TRAKTOR", 0
			));
		
		/**
		 * 13) the gate
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_tor, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_tor)), 
				R.raw.tor, "TOR", 0
			));
		
		/**
		 * 14) the rabbit
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_hasi, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_hasi)), 
				R.raw.hasi, "HASI", 0
			));
		
		/**
		 * 15) the mountain
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_farm_berg, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_farm_berg)), 
				R.raw.berg, "BERG", 0
			));
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//setContentView(this.contentViewLayout);
		this.contentViewLayout = R.layout.farm;
		
		// is this level available for non-pro-version?
		this.AVAILABLE_IN_FREE_VERSION = true;
		
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
