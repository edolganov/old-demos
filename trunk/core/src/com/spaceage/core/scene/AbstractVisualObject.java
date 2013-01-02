package com.spaceage.core.scene;

public abstract class AbstractVisualObject {
	
	protected int width;
	protected int height;
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public abstract int getRGBA(int x, int y);
	
	protected boolean inBounds(int x, int y){
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
}
