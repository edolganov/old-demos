package com.spaceage.core.scene;

import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.shape.Window;

public interface VisualObject {
	
	void draw(Window window, GraphicsManager manager, Object platformGraphics);

}
