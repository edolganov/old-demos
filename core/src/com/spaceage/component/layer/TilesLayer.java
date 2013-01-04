package com.spaceage.component.layer;

import com.spaceage.app.Global;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.scene.Window;

public class TilesLayer extends Layer {
	
	public TilesLayer(String resourcePath) {
		
		Image model = Global.factory.createImage(resourcePath);
		
	}
	
	

	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		// TODO Auto-generated method stub
		
	}

}
