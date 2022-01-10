package com.bravobene.bohbohfree.pages;

import android.os.Bundle;

import com.bravobene.bohbohfree.AnimationResource;
import com.bravobene.bohbohfree.BohbohPage;
import com.bravobene.bohbohfree.R;

public class Jungle extends BohbohPage {
	
	
	/*
	 * this method fills out the VideoResource Array of the
	 * superclass StoryBookPage
	 */
	protected void setAnimationResources(){
		
		
		
		
		/**
		 * the Gorilla
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_gorilla, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_gorilla)), 
				R.raw.gorilla, "GORILLA", R.id.btn_jungle_gorilla
			));
		
		/**
		 * the crocodile
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_croco, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_croco)), 
				R.raw.croco, "CROCO", 0
			));
		
		/**
		 * the papagei
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_papagei, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_papagei)), 
				R.raw.papagei, "PAPAGEI", 0
			));
		
		/**
		 * the tiger
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_tiger, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_tiger)), 
				R.raw.tiger, "TIGER", 0
			));
		
		/**
		 * the chameleon
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_chameleon, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_chameleon)), 
				R.raw.chameleon, "CHAMELEON", R.id.btn_jungle_chameleon
			));
		
		/**
		 * boh boh
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_bobo, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_bobo)), 
				R.raw.bobo_theme_short, "BOBO", 0
			));
		
		/**
		 * the snake
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_snake, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_snake)), 
				R.raw.snake, "SNAKE", 0
			));
		
		/**
		 * the butterfly
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_butterfly, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_butterfly)), 
				R.raw.butterfly, "BUTTERFLY", R.id.btn_jungle_butterfly
			));
		
		/**
		 * the bug
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_bug, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_bug)), 
				R.raw.bug, "BUG", R.id.btn_jungle_bug
			));
		
		/**
		 * the turtle
		 */
		animationResources.add(	new AnimationResource(
				R.id.imageView_jungle_turtle, 
				convertTypedArray(getResources().obtainTypedArray(R.array.framelist_jungle_turtle)), 
				R.raw.turtle, "TURTLE", R.id.btn_jungle_turtle
			));
		
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//setContentView(this.contentViewLayout);
		this.contentViewLayout = R.layout.jungle;
		
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
