package com.spaceage.core.platform;

import com.spaceage.core.scene.AbstractVisualObject;

public abstract class Image extends AbstractVisualObject {
	

	
	public abstract int getRGBA(int x, int y);
	
	public abstract void setRGBA(int x, int y, int rgba);


}
