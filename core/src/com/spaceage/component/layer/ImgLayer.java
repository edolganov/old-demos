package com.spaceage.component.layer;

import com.spaceage.app.Global;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.scene.Window;

public class ImgLayer extends Layer {
	
	Image img;
	
	public ImgLayer(String resourcePath) {
		img = Global.factory.createImage(resourcePath);
	}
	
	@Override
	protected void drawBackgroud(Window window, GraphicsManager manager, Object platformGraphics) {
		
		manager.draw(img, x, y, platformGraphics);
	}

}
