package com.spaceage.core.scene;

import com.spaceage.core.platform.GraphicsManager;

public interface VisualObject {
	
	int getWidth();

	int getHeight();
	
	void draw(int x, int y, GraphicsManager manager, Object platformGraphics);

}
