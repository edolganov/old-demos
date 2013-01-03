package com.spaceage.component.layer;

import com.spaceage.app.Global;
import com.spaceage.core.painter.GlobalTilesPainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;
import com.spaceage.core.scene.Window;

public class ImgLayer extends Layer {
	
	GlobalTilesPainter painter;
	
	public ImgLayer(String resourcePath) {
		Image img = Global.factory.createImage(resourcePath);
		painter = new GlobalTilesPainter(img);
	}
	
	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		painter.drawImage(0, 0, w, manager, platformGraphics);
	}

}
