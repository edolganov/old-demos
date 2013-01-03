package com.spaceage.core.platform;


public abstract class Image {
	
	public abstract int getWidth();

	public abstract int getHeight();
	
	public abstract int getRGBA(int x, int y);
	
	public abstract void setRGBA(int x, int y, int rgba);


}
