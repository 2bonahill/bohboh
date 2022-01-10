package com.bravobene.bohbohfree;

public class AnimationResource {
	
	/*
	 * imageViewId contains the id of the view in the layout file acting as
	 * a placeholder. the background of this imageview will be set to the 
	 * animationlist xml file.
	 */
	public int imageViewId;
	
	/*
	 * if just a small area of an image should be clickable, a button gets drawn over the image
	 */
	public int buttonId;
	
	/*
	 * animationListId contains the identifier (=name) of the xml file containing
	 * a listing of all the frames to be animated
	 */
	public int[] frameList;
	
	/*
	 * audio to be played while animation
	 */
	public int audioSourceId;
	
	public String name;
	
	/*
	 * the constructor
	 */
	public AnimationResource(int imageViewId, int[] frameList, int audioSourceId, String name, int buttonId) {
		// TODO Auto-generated constructor stub
		this.imageViewId = imageViewId;
		this.audioSourceId = audioSourceId;
		this.frameList = frameList;
		this.name = name;
		this.buttonId = buttonId;
	}
	
	
}
