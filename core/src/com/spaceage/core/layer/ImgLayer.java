package com.spaceage.core.layer;

import com.spaceage.core.G;
import com.spaceage.core.basic.Window;
import com.spaceage.core.painter.ImgTilesPainter;
import com.spaceage.core.platform.GraphicsManager;
import com.spaceage.core.platform.Image;
import com.spaceage.core.scene.Layer;

public class ImgLayer extends Layer {
	
	ImgTilesPainter painter;
	
	public ImgLayer(String resourcePath) {
		Image img = G.factory.createImage(resourcePath);
		painter = new ImgTilesPainter(img);
	}
	
	@Override
	protected void drawBackgroud(Window w, GraphicsManager manager, Object platformGraphics) {
		painter.drawImages(0, 0, w, manager, platformGraphics);
	}

}
