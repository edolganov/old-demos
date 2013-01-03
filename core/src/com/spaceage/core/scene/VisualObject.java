package com.spaceage.core.scene;

import com.spaceage.core.platform.GraphicsManager;

public interface VisualObject {
	
	void draw(Window window, GraphicsManager manager, Object platformGraphics);

}
