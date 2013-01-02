package com.spaceage.core.scene;

public abstract class Layer implements VisualObject {
	
	
	@Override
	public int getRGBA(int x, int y){
		return getBackgroundRGBA(x, y);
	}
	
	
	protected abstract int getBackgroundRGBA(int x, int y);

}
