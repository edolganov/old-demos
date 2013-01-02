package com.spaceage.core.scene;

public abstract class AbstractVisualObject implements VisualObject {
	
	protected int width;
	protected int height;
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public abstract int getRGBA(int x, int y);
	
	protected boolean inBounds(int x, int y){
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
}
